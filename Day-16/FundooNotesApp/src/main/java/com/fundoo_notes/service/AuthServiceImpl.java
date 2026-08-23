package com.fundoo_notes.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fundoo_notes.dto.request.user.ForgetPasswordRequestDTO;
import com.fundoo_notes.dto.request.user.LoginRequestDTO;
import com.fundoo_notes.dto.request.user.RegisterRequestDTO;
import com.fundoo_notes.dto.request.user.ResetPasswordRequestDTO;
import com.fundoo_notes.dto.request.user.UserPatchRequestDTO;
import com.fundoo_notes.dto.response.LoginResponseDTO;
import com.fundoo_notes.dto.response.UserResponseDTO;
import com.fundoo_notes.entity.User;
import com.fundoo_notes.exception.InvalidResetTokenException;
import com.fundoo_notes.exception.ResetTokenExpiredException;
import com.fundoo_notes.exception.UserAlreadyExistsException;
import com.fundoo_notes.exception.UserNotFoundException;
import com.fundoo_notes.repository.UserRepository;
import com.fundoo_notes.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public UserResponseDTO registerUser(RegisterRequestDTO registerRequest) {

		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			throw new UserAlreadyExistsException("Email already exists");
		}

		User user = new User();

		user.setName(registerRequest.getName());
		user.setEmail(registerRequest.getEmail());
		user.setPhone(registerRequest.getPhone());

		String encodePassword = passwordEncoder.encode(registerRequest.getPassword());

		user.setPassword(encodePassword);

		user.setTokenVersion(0);
		User savedUser = userRepository.save(user);

		return toResponse(savedUser);
	}

	public LoginResponseDTO loginUser(LoginRequestDTO loginRequest) {

		// authenticate email and password
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

	   User user = userRepository.findByEmail(loginRequest.getEmail())
	                .orElseThrow(() ->new UserNotFoundException("User not found"));
	     
		// generate jwt
		String token = jwtService.generateToken(loginRequest.getEmail(),user.getTokenVersion() );

		return new LoginResponseDTO("Login successfully", token);
	}

	@Override
	public String forgotPassword(ForgetPasswordRequestDTO request) {

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new UserNotFoundException("User not found with this email"));

		// generate reset token
		String resetToken = UUID.randomUUID().toString();

		// save token
		user.setResetToken(resetToken);

		// token valid for 15 min
		user.setResetTokenExpiry(LocalDateTime.now().plusMinutes(15));

		userRepository.save(user);

		return resetToken;
	}

	@Override
	public String resetPassword(ResetPasswordRequestDTO request) {

		User user = userRepository.findByResetToken(request.getToken())
				.orElseThrow(() -> new InvalidResetTokenException("Invalid reset token"));

		if (user.getResetTokenExpiry() == null || user.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
			throw new ResetTokenExpiredException("Reset token has expired");
		}

		user.setPassword(passwordEncoder.encode(request.getNewPassword()));

		user.setTokenVersion(user.getTokenVersion() + 1);

		user.setResetToken(null);
		user.setResetTokenExpiry(null);

		userRepository.save(user);

		return "Password reset successfully";
	}

	public UserResponseDTO updateUser(UserPatchRequestDTO request) {

		User currentUser = getCurrentUser();

		currentUser.setName(request.getName());
		currentUser.setPhone(request.getPhone());

		return toResponse(userRepository.save(currentUser));
	}

	private User getCurrentUser() {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	public UserResponseDTO toResponse(User user) {

		UserResponseDTO response = new UserResponseDTO();

		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setPhone(user.getPhone());

		return response;

	}

}
