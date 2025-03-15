package com.back.ycar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.back.ycar.dto.Member;

@Mapper
public interface MemberDao {

	public void insertMember(Member m) throws Exception;
	public void updateMember(Member m) throws Exception;
	public void deleteMember(String email) throws Exception;
	boolean existsByUserId(String userId);

}


