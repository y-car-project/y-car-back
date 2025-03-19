package com.back.ycar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.back.ycar.dto.AllCarList;


@Mapper
public interface AllCarListDao {
	public  List<AllCarList> getAllCarList() throws Exception;

}
