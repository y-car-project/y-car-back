package com.back.ycar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.back.ycar.service.OAuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class OAuthController {

	@Value("${kakao.api.key}")
	String KAKAO_API_KEY ;

	@Autowired
	OAuthService oAuthService;

	@GetMapping("kakaoLogin")
	public String kakaoLogin() {

		return "redirect:https://kauth.kakao.com/oauth/authorize?client_id="
		+ KAKAO_API_KEY
				+ "&redirect_uri=http://localhost:8080/kakaoLoginCallback&response_type=code";
	}

	@GetMapping("kakaoLoginCallback")
	public String kakaoCallback(@RequestParam String code, HttpServletRequest request, HttpServletResponse response) throws Exception{
	  System.out.println("사용자 동의 코드:" + code);
	  String access_Token = oAuthService.getKaKaoAccessToken(code);
	  System.out.println("access_Token :" + access_Token );
	  String email = oAuthService.getKakaoUser(access_Token);
	  System.out.println("email  :" + email  );

	  if (email != null) {
		// db에 저장
		oAuthService.insertLoginInfo(email, access_Token);

		Cookie c1 = new Cookie("email", email);
		Cookie c2 = new Cookie("Authorization", access_Token);

		response.addCookie(c1);
		response.addCookie(c2);

	}
		return "redirect:http://localhost:3000/";
	}
}