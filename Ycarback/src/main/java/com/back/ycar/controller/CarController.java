package com.back.ycar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.back.ycar.cache.CacheStorage;
import com.back.ycar.dto.Car;
import com.back.ycar.service.CarService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/insertCar")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CacheStorage cacheStorage;
    
    @PostMapping
    public ResponseEntity<String> registerCar(
            @RequestParam("car_name") String carName,
            @RequestParam("car_price") int carPrice,
            @RequestParam("car_year") int carYear,
            @RequestParam("car_km") int carKm,
            @RequestParam("car_fuel") String carFuel,
            @RequestParam("car_img") String carImg
    ) {
        try {
            Car car = new Car();
            car.setCarName(carName);
            car.setCarPrice(carPrice);
            car.setCarYear(carYear);
            car.setCarKm(carKm);
            car.setCarFuel(carFuel);
            car.setCarImg(carImg);

            carService.registerCar(car);
            
            // 캐시 무효화: 새로운 차량 등록 후 "firstPageCars" 캐시를 삭제
            cacheStorage.remove("firstPageCars");
            // 필요에 따라 "weeklyCars"도 무효화할 수 있습니다.
            // cacheStorage.remove("weeklyCars");
            
            return ResponseEntity.ok("차량 등록 성공");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("차량 등록 실패");
        }
    }
}
