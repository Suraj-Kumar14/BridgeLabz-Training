package com.fundoo.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;

import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(
            ServerHttpSecurity http) {

        return http

                .csrf(ServerHttpSecurity.CsrfSpec::disable)

                .formLogin(
                        ServerHttpSecurity.FormLoginSpec::disable)

                .httpBasic(
                        ServerHttpSecurity.HttpBasicSpec::disable)

                .authorizeExchange(exchange -> exchange

                        .pathMatchers(
                                "/api/auth/register",
                                "/api/auth/login",
                                "/api/auth/verify-otp",
                                "/api/auth/resend-otp",
                                "/api/auth/forgot-password",
                                "/api/auth/reset-password"
                        )
                        .permitAll()

                        .pathMatchers("/actuator/**")
                        .permitAll()

                        .anyExchange()
                        .permitAll()
                )

                .build();
    }
}