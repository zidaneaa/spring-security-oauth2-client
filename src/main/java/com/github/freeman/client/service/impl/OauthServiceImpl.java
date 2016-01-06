package com.github.freeman.client.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.freeman.client.dto.AccessTokenDto;
import com.github.freeman.client.dto.AuthAccessTokenDto;
import com.github.freeman.client.dto.AuthCallbackDto;
import com.github.freeman.client.infrastructure.httpclient.RestClient;
import com.github.freeman.client.infrastructure.httpclient.StringUtils;
import com.github.freeman.client.service.OauthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Freeman on 2016/1/6.
 */
@Service("oauthService")
public class OauthServiceImpl implements OauthService {

    private static final Logger LOG = LoggerFactory.getLogger(OauthServiceImpl.class);


    @Value("#{properties['access-token-uri']}")
    private String accessTokenUri;
    @Override
    public AccessTokenDto retrieveAccessTokenDto(AuthAccessTokenDto tokenDto) {
        final String fullUri = tokenDto.getAccessTokenUri();
        LOG.debug("Get access_token URL: {}", fullUri);

        return loadAccessTokenDto(fullUri, tokenDto.getAuthCodeParams());
    }

    @Override
    public AuthAccessTokenDto createAuthAccessTokenDto(AuthCallbackDto callbackDto) {
        return new AuthAccessTokenDto().setAccessTokenUri(accessTokenUri).setCode(callbackDto.getCode());
    }

    private AccessTokenDto loadAccessTokenDto(String fullUri, Map<String, Object> params) {

        String post = RestClient.post(fullUri, StringUtils.parseMapToString(params));
        LOG.info("获取的结果为："+post);


        AccessTokenDto accessTokenDto = JSON.parseObject(post, AccessTokenDto.class);
        LOG.info(accessTokenDto.toString());
        return accessTokenDto;
    }
}
