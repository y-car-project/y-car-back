package com.back.ycar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.ycar.dto.Login;
import com.back.ycar.dto.Member;
import com.back.ycar.service.MemberService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("logout")
	public void logout(@RequestHeader String authorization) {
		System.out.println(authorization);
		try {
			memberService.logout(authorization);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostMapping("tokenLogin")
	public Map<String,String> tokenLogin(@RequestBody Member m) {
		System.out.println(m);
		
		Map<String,String> responseMap=new HashMap<>();
		
		try {
			Login loginInfo=memberService.tokenLogin(m);
			
			if(loginInfo!=null && loginInfo.getUser_id()!=null && loginInfo.getUser_token()!=null) {
				responseMap.put("nickname", loginInfo.getUser_id());
				responseMap.put("Authorization", loginInfo.getUser_token());
				responseMap.put("success", "true"); // 로그인 성공 플래그 추가
			}else {
				responseMap.put("msg", "다시 로그인 해주세요");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseMap.put("msg", "다시 로그인 해주세요");
		}
		return responseMap;
	}
	@PostMapping("login")
	public Map<String, String> login(@RequestBody Member m) {
	    System.out.println(m);
	    Map<String, String> responseMap = new HashMap<>();
	    
	    try {
	        m = memberService.login(m);
	        if (m != null) {
	            String id = m.getUser_id();
	            if (id != null && !id.trim().equals("")) {
	                responseMap.put("success", "true"); // 로그인 성공 플래그 추가
	                responseMap.put("id", id);
	            } else {
	                responseMap.put("success", "false");
	                responseMap.put("msg", "닉네임 정보가 없습니다. 다시 로그인 해주세요");
	            }
	        } else {
	            responseMap.put("success", "false");
	            responseMap.put("msg", "회원 정보를 찾을 수 없습니다. 다시 로그인 해주세요");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        responseMap.put("success", "false");
	        responseMap.put("msg", "로그인 중 오류가 발생했습니다");
	    }
	    return responseMap;
	}


	@GetMapping("/checkUserId")
	public ResponseEntity<Map<String, Boolean>> checkUserId(@RequestParam("userId") String userId) {
	    System.out.println("중복 확인 요청: userId = " + userId); // 디버깅 로그 추가
	    boolean available = memberService.isUserIdAvailable(userId);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("available", available);
	    return ResponseEntity.ok(response);
	}

	
	@PostMapping("insertMember")
	public ResponseEntity<Map<String, String>> insertMember(@RequestBody Member m) {
	    Map<String, String> response = new HashMap<>();
	    try {
	        memberService.insertMember(m);
	        response.put("message", m.getUser_name() + "님 가입을 환영합니다");
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("message", "회원 가입 실패");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
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
