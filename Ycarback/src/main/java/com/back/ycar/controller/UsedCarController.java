package com.back.ycar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.ycar.dto.UsedCar;
import com.back.ycar.service.UsedCarService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UsedCarController {

    @Autowired
    private UsedCarService usedCarService;

    // 모든 중고차 조회
    @GetMapping("getAllUsedCars")
    public List<UsedCar> getAllUsedCars() {
        try {
            long start = System.currentTimeMillis();  // 조회 시간 측정 시작
            List<UsedCar> cars = usedCarService.getAllUsedCars();
            long end = System.currentTimeMillis();    // 조회 시간 측정 종료
            System.out.println("조회 시간: " + (end - start) + "ms");
            return cars;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 주간 추천 중고차 조회
    @GetMapping("getWeeklyCars")
    public List<UsedCar> getWeeklyCars() {
        try {
            return usedCarService.getWeeklyCars();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
