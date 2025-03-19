package com.back.ycar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
        List<UsedCar> updatedCars = usedCarDao.getAllUsedCars();
        redisTemplate.opsForValue().set(USED_CARS_KEY, updatedCars);
        System.out.println("Redis 캐시 갱신 완료");
    }
}