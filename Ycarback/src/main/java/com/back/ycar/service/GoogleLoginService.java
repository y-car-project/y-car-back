package com.back.ycar.service;

import com.back.ycar.dao.LoginDao;
import com.back.ycar.dto.GoogleOAuth;
import com.back.ycar.dto.Login;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleLoginService {
    @Value("${google.oauth.client-id}")
    private String CLIENT_ID;
    
    @Value("${google.oauth.client-secret}")
    private String CLIENT_SECRET;
    
    @Value("${google.oauth.redirect-uri}")
    private String REDIRECT_URI;

    @Autowired
    LoginDao loginDao;
    
    public void insertLoginInfo(String email, String googleToken) throws Exception {
        Login loginInfo = new Login(email, googleToken, new Date());
        loginDao.insertToken(loginInfo);
    }
    
    public GoogleOAuth loginWithGoogle(String code) {
        RestTemplate restTemplate = new RestTemplate();
        String tokenUrl = "https://oauth2.googleapis.com/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("client_id", CLIENT_ID);
        params.add("client_secret", CLIENT_SECRET);
        params.add("redirect_uri", REDIRECT_URI);
        params.add("grant_type", "authorization_code");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(tokenUrl, requestEntity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(responseEntity.getBody());

                String accessToken = jsonNode.get("access_token").asText();
                String refreshToken = jsonNode.has("refresh_token") ? jsonNode.get("refresh_token").asText() : null;

                // 사용자 정보 가져오기
                String userInfoUrl = "https://www.googleapis.com/oauth2/v2/userinfo";
                HttpHeaders userInfoHeaders = new HttpHeaders();
                userInfoHeaders.setBearerAuth(accessToken);
                HttpEntity<String> userInfoEntity = new HttpEntity<>(userInfoHeaders);
                ResponseEntity<String> userInfoResponse = restTemplate.exchange(userInfoUrl, HttpMethod.GET, userInfoEntity, String.class);
                
                String email = null;
                if (userInfoResponse.getStatusCode() == HttpStatus.OK) {
                    JsonNode userInfoNode = mapper.readTree(userInfoResponse.getBody());
                    if (userInfoNode.has("email")) {
                        email = userInfoNode.get("email").asText();
                    }
                }

                // DTO에 email 정보도 포함시켜 반환 (DTO 생성자 수정 필요)
                return new GoogleOAuth(code, accessToken, refreshToken, email);
            } catch (Exception e) {
                throw new RuntimeException("구글 토큰 응답 파싱 실패", e);
            }
        } else {
            throw new RuntimeException("구글 토큰 교환 실패: " + responseEntity.getStatusCode());
        }
    }
}
