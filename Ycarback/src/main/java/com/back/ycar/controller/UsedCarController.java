package com.back.ycar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.ycar.cache.CacheStorage;
import com.back.ycar.dto.UsedCar;
import com.back.ycar.service.UsedCarService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UsedCarController {

    @Autowired
    private UsedCarService usedCarService;

    @Autowired
    private CacheStorage cacheStorage;
    
    @GetMapping("getAllUsedCars")
    public List<UsedCar> getAllUsedCars() {
        try {
            Object o = cacheStorage.get("firstPageCars");
            if (o == null) {
                List<UsedCar> list = usedCarService.getAllUsedCars();
                cacheStorage.put("firstPageCars", list);
                return list;
            }
            return (List<UsedCar>) o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @GetMapping("getWeeklyCars")
    public List<UsedCar> getWeeklyCars() {
        try {
            Object o = cacheStorage.get("weeklyCars");
            if (o == null) {
                List<UsedCar> list = usedCarService.getWeeklyCars();
                cacheStorage.put("weeklyCars", list);
                return list;
            }
            return (List<UsedCar>) o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
