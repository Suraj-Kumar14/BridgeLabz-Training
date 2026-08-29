package com.fundoo.auth.filter;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fundoo.auth.entity.User;
import com.fundoo.auth.repository.UserRepository;
import com.fundoo.auth.security.CustomUserDetailsService;
import com.fundoo.auth.security.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtService jwtService;

	private final CustomUserDetailsService userDetailsService;

	private final UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authorizationHeader = request.getHeader("Authorization");

		// No JWT → continue
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {

			filterChain.doFilter(request, response);
			return;
		}

		String token = authorizationHeader.substring(7);

		try {

			String email = jwtService.extractEmail(token);

			if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				Optional<User> optionalUser = userRepository.findByEmail(email);

				if (optionalUser.isEmpty()) {

					filterChain.doFilter(request, response);
					return;
				}

				User user = optionalUser.get();

				if (jwtService.isTokenValid(token, user)) {


					UserDetails userDetails = userDetailsService.loadUserByUsername(email);

					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}

		} catch (Exception e) {

			SecurityContextHolder.clearContext();
		}

		filterChain.doFilter(request, response);
	}

}
