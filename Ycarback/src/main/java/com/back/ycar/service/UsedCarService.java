package com.back.ycar.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.back.ycar.cache.CacheStorage;
import com.back.ycar.dao.UsedCarDao;
import com.back.ycar.dto.UsedCar;

@Service
public class UsedCarService {

    @Autowired
    UsedCarDao usedCarDao;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String USED_CARS_KEY = "usedCars";

    // 메인 페이지 조회 (캐시 먼저 확인)
    @Cacheable(value = "usedCars")
    public List<UsedCar> getAllUsedCars() throws Exception {
        List<UsedCar> cars = (List<UsedCar>) redisTemplate.opsForValue().get(USED_CARS_KEY);

        if (cars == null) {
            System.out.println("Fetching from DB...");
            cars = usedCarDao.getAllUsedCars();
            redisTemplate.opsForValue().set(USED_CARS_KEY, cars, 1, TimeUnit.HOURS);  // 캐시 저장 및 TTL 설정
            System.out.println("캐시가 없어서 DB 조회 후 Redis에 저장");
        } else {
            System.out.println("Redis에서 데이터 가져옴");
        }
        
        return cars;
    }

    public List<UsedCar> getWeeklyCars() throws Exception {
        return usedCarDao.getWeeklyCars();
    }
}