package com.back.ycar.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.back.ycar.dao.CarDao;
import com.back.ycar.dao.UsedCarDao;
import com.back.ycar.dto.Car;
import com.back.ycar.dto.UsedCar;

@Service
public class CarService {

    @Autowired
    CarDao carDao;
    @Autowired
    UsedCarDao usedCarDao;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String USED_CARS_KEY = "usedCars";

    public void registerCar(Car car) throws Exception {
        // 등록 로직 (필요에 따라 트랜잭션 처리 등 추가)
        carDao.insertCar(car);
        System.out.println("SQL 등록");

        // Redis 캐시 갱신
        List<UsedCar> newCars = (List<UsedCar>) redisTemplate.opsForValue().get(USED_CARS_KEY);
        if (newCars != null) {
        	newCars.add(new UsedCar(car)); // 추가된 차량을 직접 리스트에 추가
        	newCars.sort(Comparator.comparing(UsedCar::getCar_code).reversed()); // 내림차순 정렬

        	redisTemplate.opsForValue().set(USED_CARS_KEY, newCars);
            System.out.println("Redis 캐시 직접 갱신 완료");
        } else {
            // 캐시가 없는 경우 DB에서 조회 후 캐시에 저장
            List<UsedCar> updatedCars = usedCarDao.getAllUsedCars();
            redisTemplate.opsForValue().set(USED_CARS_KEY, updatedCars);
            System.out.println("Redis 캐시 초기화 완료");
        }
    }
}