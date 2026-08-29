package com.fundoo.gateway.filter;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements GlobalFilter {

    private final SecretKey secretKey;

    public JwtAuthenticationFilter(
            @Value("${jwt.secret}") String secret) {

        this.secretKey = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        String path = exchange
                .getRequest()
                .getURI()
                .getPath();

        if (isPublicEndpoint(path)) {
            return chain.filter(exchange);
        }

        String authorizationHeader = exchange
                .getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);


        if (authorizationHeader == null
                || !authorizationHeader.startsWith("Bearer ")) {

            return unauthorized(exchange);
        }

        String token = authorizationHeader.substring(7);

        try {

            Claims claims = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String email = claims.getSubject();

            Long userId = claims.get(
                    "userId",
                    Long.class
            );

            Integer tokenVersion = claims.get(
                    "tokenVersion",
                    Integer.class
            );

            if (email == null || userId == null) {
                return unauthorized(exchange);
            }

            // ============================================
            // REMOVE CLIENT-SUPPLIED HEADERS
            //
            // Client should not be able to send:
            // X-User-Id: 999
            // ============================================

            ServerWebExchange modifiedExchange =
                    exchange.mutate()
                            .request(request ->
                                    request.headers(headers -> {

                                        headers.remove("X-User-Id");
                                        headers.remove("X-User-Username");
                                        headers.remove("X-Token-Version");

                                        headers.add(
                                                "X-User-Id",
                                                String.valueOf(userId)
                                        );

                                        headers.add(
                                                "X-User-Username",
                                                email
                                        );

                                        if (tokenVersion != null) {

                                            headers.add(
                                                    "X-Token-Version",
                                                    String.valueOf(tokenVersion)
                                            );
                                        }
                                    })
                            )
                            .build();

            return chain.filter(modifiedExchange);

        } catch (Exception exception) {

            return unauthorized(exchange);
        }
    }

    private boolean isPublicEndpoint(String path) {

        return path.equals("/api/auth/register")
                || path.equals("/api/auth/login")
                || path.equals("/api/auth/verify-otp")
                || path.equals("/api/auth/resend-otp")
                || path.equals("/api/auth/forgot-password")
                || path.equals("/api/auth/reset-password")
                || path.startsWith("/actuator");
    }

    private Mono<Void> unauthorized(
            ServerWebExchange exchange) {

        exchange.getResponse()
                .setStatusCode(HttpStatus.UNAUTHORIZED);

        return exchange
                .getResponse()
                .setComplete();
    }
}