package com.back.ycar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.back.ycar.dto.UsedCar;

@Mapper
public interface UsedCarDao {
	public  List<UsedCar> getAllUsedCars() throws Exception;

	public List<UsedCar> getWeeklyCars() throws Exception;
}
