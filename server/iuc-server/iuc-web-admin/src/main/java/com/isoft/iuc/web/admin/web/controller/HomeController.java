package com.isoft.iuc.web.admin.web.controller;

import com.isoft.iuc.service.impl.UserService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Created by liuqiang03 on 2017/6/27.
 */
@RestController
@RequestMapping("/")
public class HomeController {
    @Value("${security.oauth2.client.client-id}")
    private String oAuth2ClientId;

    @Value("${security.oauth2.client.client-secret}")
    private String oAuth2ClientSecret;

    @Value("${security.oauth2.client.access-token-uri}")
    private String accessTokenUri;

    UserService service;

    @Autowired
    public HomeController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String get() {
        return "User Center";
    }

    @PostMapping
    public ResponseEntity<OAuth2AccessToken> refresh(@RequestBody String refreshToken) {
        String accessToken = String.valueOf(RequestContextHolder.getRequestAttributes().getAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE, 0));

        RestTemplate template = new RestTemplate();
        String basic = oAuth2ClientId + ":" + oAuth2ClientSecret;

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
        requestHeaders.add("Authorization", "Basic " + Base64.encodeBase64String(basic.getBytes()));

        String params = String.format("grant_type=refresh_token&access_token=%s&refresh_token=%s", accessToken, refreshToken);
        HttpEntity<String> requestEntity = new HttpEntity<>(params, requestHeaders);

        ResponseEntity<OAuth2AccessToken> responseEntity = template.exchange(accessTokenUri, HttpMethod.POST, requestEntity, OAuth2AccessToken.class);

        return responseEntity;
    }
}
