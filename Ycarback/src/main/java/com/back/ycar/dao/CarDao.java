package com.back.ycar.dao;

import org.apache.ibatis.annotations.Mapper;

import com.back.ycar.dto.Car;

@Mapper
public interface CarDao {

    public void insertCar(Car car) throws Exception;
}

