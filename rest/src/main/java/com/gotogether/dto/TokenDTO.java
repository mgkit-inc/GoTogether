package com.gotogether.dto;

public class TokenDTO {

    private String accessToken;

    private String refreshToken;

    public TokenDTO() {

    }

    public TokenDTO(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
