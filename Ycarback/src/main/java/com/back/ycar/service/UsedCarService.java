package com.back.ycar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.ycar.dao.UsedCarDao;
import com.back.ycar.dto.UsedCar;

@Service
public class UsedCarService {
	
	@Autowired
	UsedCarDao usedCarDao;
	
	public List<UsedCar> getAllUsedCars() throws Exception {
		return usedCarDao.getAllUsedCars();
	}

	public List<UsedCar> getWeeklyCars() throws Exception {
		return usedCarDao.getWeeklyCars();
	}
}