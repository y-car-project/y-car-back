package com.back.ycar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.ycar.dao.AllCarListDao;
import com.back.ycar.dto.AllCarList;

@Service
public class AllCarListService {

	@Autowired
	AllCarListDao allCarListDao;

	public List<AllCarList> getAllUsedCars() throws Exception {
		return allCarListDao.getAllCarList();
	}
}