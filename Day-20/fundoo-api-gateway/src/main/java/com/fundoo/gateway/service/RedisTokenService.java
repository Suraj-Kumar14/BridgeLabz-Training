package com.fundoo.gateway.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisTokenService {

    private static final String TOKEN_PREFIX = "auth:token:";

    private final StringRedisTemplate redisTemplate;

    public boolean isTokenPresent(String token) {

        String key = TOKEN_PREFIX + token;

        return Boolean.TRUE.equals(
                redisTemplate.hasKey(key)
        );
    }


    public void removeToken(String token) {

        String key = TOKEN_PREFIX + token;

        redisTemplate.delete(key);
    }
}