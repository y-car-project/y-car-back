package com.back.ycar.dao;

import org.apache.ibatis.annotations.Mapper;

import com.back.ycar.dto.Car;

@Mapper
public interface CarDao {
    // 차량 등록: insert문 실행 후, 자동 생성된 id를 Car 객체에 설정
    public void insertCar(Car car) throws Exception;
}

