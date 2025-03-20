package com.back.ycar.dto;

public class GoogleOAuth {
    private String code;
    private String accessToken;
    private String refreshToken;
    private String email;  // 추가

    public GoogleOAuth() {}

    public GoogleOAuth(String code, String accessToken, String refreshToken, String email) {
        this.code = code;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.email = email;
    }

    // 기존 생성자와 메서드에 email 관련 부분을 추가하거나 수정합니다.
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
