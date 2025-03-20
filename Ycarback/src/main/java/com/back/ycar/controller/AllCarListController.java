package com.back.ycar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.ycar.dto.AllCarList;
import com.back.ycar.service.AllCarListService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AllCarListController {

	@Autowired
	AllCarListService allCarListService;
	Map<String,Object> storage = new HashMap<>();

	@GetMapping("getAllCarList")
	public List<AllCarList> getAllCarList() {
		try {
			Object o=storage.get("firstPageCars");
			if(o==null) {
				List<AllCarList> list=allCarListService.getAllUsedCars();
				storage.put("carList", list);
				return list;
			}
			return (List<AllCarList>)o;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
