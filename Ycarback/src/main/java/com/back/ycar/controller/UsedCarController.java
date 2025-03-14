package com.back.ycar.controller;

import java.util.*;

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
	UsedCarService usedCarService;
	
	Map<String,Object> storage = new HashMap<>();
	
	@GetMapping("getAllUsedCars")
	public List<UsedCar> getAllUsedCars() {
		try {
			Object o=storage.get("firstPageCars");
			if(o==null) {
				List<UsedCar> list=usedCarService.getAllUsedCars();
				storage.put("firstPageCars", list);
				return list;
			}
			return (List<UsedCar>)o;
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
