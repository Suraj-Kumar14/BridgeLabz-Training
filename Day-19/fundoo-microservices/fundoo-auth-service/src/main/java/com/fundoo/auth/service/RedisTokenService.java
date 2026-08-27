package com.fundoo.auth.service;

import java.time.Duration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisTokenService {

	private static final String TOKEN_PREFIX = "auth:token:";

	private final RedisTemplate<String, String> redisTemplate;

	// Store JWT in Redis.
	
	public void saveToken(String token, String email, long expirationMillis) {

		String key = TOKEN_PREFIX + token;

		redisTemplate.opsForValue().set(key, email, Duration.ofMillis(expirationMillis));
	}

	// Check whether JWT exists in Redis.
	 
	public boolean isTokenPresent(String token) {

		String key = TOKEN_PREFIX + token;

		return Boolean.TRUE.equals(redisTemplate.hasKey(key));
	}

	// Get email associated with JWT.
	 
	public String getEmail(String token) {

		String key = TOKEN_PREFIX + token;

		return redisTemplate.opsForValue().get(key);
	}

	// Delete JWT from Redis.
	 
	public void deleteToken(String token) {

		String key = TOKEN_PREFIX + token;

		redisTemplate.delete(key);
	}
}