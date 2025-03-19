package com.back.ycar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.ycar.dao.CarDao;
import com.back.ycar.dto.Car;

@Service
public class CarService {
    
    @Autowired
    CarDao carDao;
    
    public void registerCar(Car car) throws Exception {
        // 등록 로직 (필요에 따라 트랜잭션 처리 등 추가)
        carDao.insertCar(car);
    }
}

