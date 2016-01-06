package com.github.freeman.client.service;


import com.github.freeman.client.dto.AccessTokenDto;
import com.github.freeman.client.dto.AuthAccessTokenDto;
import com.github.freeman.client.dto.AuthCallbackDto;

public interface OauthService {


    AccessTokenDto retrieveAccessTokenDto(AuthAccessTokenDto tokenDto);

    AuthAccessTokenDto createAuthAccessTokenDto(AuthCallbackDto callbackDto);

}