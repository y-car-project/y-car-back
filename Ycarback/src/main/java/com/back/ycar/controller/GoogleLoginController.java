package com.back.ycar.controller;

import com.back.ycar.dto.GoogleOAuth;
import com.back.ycar.service.GoogleLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  // JSON 응답을 자동으로 처리하기 위해 @RestController 사용
@CrossOrigin(origins = "http://localhost:3000")  // 필요 시 CORS 설정
public class GoogleLoginController {

    @Autowired
    private GoogleLoginService googleLoginService;

    @PostMapping("/googleLogin")
    public ResponseEntity<GoogleOAuth> googleLogin(@RequestBody GoogleOAuth authDto) throws Exception {
        System.out.println("일단 여기는 왔어");
        // 전달받은 code를 사용해 토큰 교환 및 사용자 정보 가져오기
        GoogleOAuth resultDto = googleLoginService.loginWithGoogle(authDto.getCode());

        // email과 access token이 존재하는 경우 DB에 저장
        if (resultDto.getEmail() != null && resultDto.getAccessToken() != null) {
            googleLoginService.insertLoginInfo(resultDto.getEmail(), resultDto.getAccessToken());
        }
        
        return ResponseEntity.ok(resultDto);
    }
}
