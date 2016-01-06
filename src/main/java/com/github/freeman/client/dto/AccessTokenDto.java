package com.github.freeman.client.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 15-5-18
 * <p/>
 * {"access_token":"d580fbfe-da2c-4840-8b66-848168ad8d62","token_type":"bearer","refresh_token":"9406e12f-d62e-42bd-ad40-0206d94ae776","expires_in":43199,"scope":"read write"}
 *
 * @author Shengzhao Li
 */
public class AccessTokenDto extends AbstractOauthDto {

    @JSONField(name = "access_token")
    private String accessToken;
    @JSONField(name = "token_type")
    private String tokenType;
    @JSONField(name = "refresh_token")
    private String refreshToken;
    @JSONField(name = "scope")
    private String scope;
    @JSONField(name = "expires_in")
    private int expiresIn;


    public AccessTokenDto() {
    }


    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{accessToken='").append(accessToken).append('\'');
        sb.append(", tokenType='").append(tokenType).append('\'');
        sb.append(", refreshToken='").append(refreshToken).append('\'');
        sb.append(", scope='").append(scope).append('\'');
        sb.append(", expiresIn=").append(expiresIn);
        sb.append(", errorDescription='").append(errorDescription).append('\'');
        sb.append(", error='").append(error).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
