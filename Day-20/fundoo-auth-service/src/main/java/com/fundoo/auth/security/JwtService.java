package com.fundoo.auth.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fundoo.auth.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;


    public SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }


    public String generateToken(
            Long userId,
            String email,
            Integer tokenVersion) {

        return Jwts.builder()
                .subject(email)

                .claim("userId", userId)

                .claim("tokenVersion", tokenVersion)

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + expiration
                        )
                )

                .signWith(getSigningKey())
                .compact();
    }


    public String extractEmail(String token) {

        Claims claims =
                Jwts.parser()
                        .verifyWith(getSigningKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

        return claims.getSubject();
    }


    public Integer extractTokenVersion(String token) {

        Claims claims =
                Jwts.parser()
                        .verifyWith(getSigningKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

        return claims.get(
                "tokenVersion",
                Integer.class
        );
    }
    
    public Long extractUserId(String token) {

        Claims claims =
                Jwts.parser()
                        .verifyWith(getSigningKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

        return claims.get("userId", Long.class);
    }


    public boolean isTokenValid(
            String token,
            User user) {

        try {

            String email =
                    extractEmail(token);

            Integer tokenVersion =
                    extractTokenVersion(token);


            // Email must match
            boolean emailMatches =
                    email != null
                            && email.equals(user.getEmail());


            // Token version must match
            boolean tokenVersionMatches =
                    tokenVersion != null
                            && tokenVersion.equals(
                                    user.getTokenVersion()
                            );


            // JWT must not be expired
            boolean tokenNotExpired =
                    !isTokenExpired(token);


            return emailMatches
                    && tokenVersionMatches
                    && tokenNotExpired;

        } catch (Exception e) {

            return false;
        }
    }


    private boolean isTokenExpired(
            String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration()
                .before(new Date());
    }


    public long getExpiration() {

        return expiration;
    }
}