package com.fundoo.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fundoo.auth.security.JwtAuthenticationFilter;


@Configuration
public class SecurityConfig {


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter)throws Exception {

		http.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/api/auth/register", "/api/auth/verify-otp", "/api/auth/login",
								"/api/auth/forgot-password", "/api/auth/reset-password","/api/auth/resend-otp")
						.permitAll().requestMatchers(
	                            "/swagger-ui/**",
	                            "/swagger-ui.html",
	                            "/v3/api-docs/**"
	                    )
	                    .permitAll().anyRequest().authenticated()).addFilterBefore(
	                            jwtAuthenticationFilter,
	                            org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class
	                    );;

		return http.build();

	}

}
