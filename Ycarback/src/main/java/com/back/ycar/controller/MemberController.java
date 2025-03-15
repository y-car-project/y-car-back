package com.back.ycar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.back.ycar.dto.Member;
import com.back.ycar.service.MemberService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/checkUserId")
	public ResponseEntity<Map<String, Boolean>> checkUserId(@RequestParam("userId") String userId) {
	    System.out.println("중복 확인 요청: userId = " + userId); // 디버깅 로그 추가
	    boolean available = memberService.isUserIdAvailable(userId);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("available", available);
	    return ResponseEntity.ok(response);
	}

	
	@PostMapping("insertMember")
	public String insertMember(@RequestBody Member m) {
		System.out.println(m);
		try {
			memberService.insertMember(m);
			return m.getUser_name()+"님 가입을 환영합니다";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "회원 가입 실패";
		}
	}
	
	@PostMapping("updateMember")
	public String updateMember(@RequestBody Member m) {
		System.out.println(m);
		try {
			memberService.updateMember(m);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "email과 pwd 확인해 주세요";
		}
	}
	
	@PostMapping("deleteMember")
	public String deleteMember(@RequestBody String email) {
		System.out.println(email);
		try {
			memberService.deleteMember(email);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "email과 pwd 확인해 주세요";
		}
	}

}
