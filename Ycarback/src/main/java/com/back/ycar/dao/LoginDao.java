package com.back.ycar.dao;
import org.apache.ibatis.annotations.Mapper;
import com.back.ycar.dto.Login;

@Mapper
public interface LoginDao {	
	public void insertToken(Login login) throws Exception;

	public void deleteToken(String token) throws Exception;
}
