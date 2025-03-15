package com.back.ycar.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.ycar.dao.MemberDao;
import com.back.ycar.dto.Member;
import com.back.ycar.util.OpenCrypt;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
		
	public void insertMember(Member m) throws Exception{
		memberDao.insertMember(m);
	}
	
	public void updateMember(Member m) throws Exception{
		memberDao.updateMember(m);
	}
	
	public void deleteMember(String email) throws Exception{
		memberDao.deleteMember(email);
	}


	public boolean isUserIdAvailable(String userId) {
        // memberRepository.existsByUserId(userId)가 true면 이미 존재하는 아이디
        return memberDao.existsByUserId(userId);
    }

}
