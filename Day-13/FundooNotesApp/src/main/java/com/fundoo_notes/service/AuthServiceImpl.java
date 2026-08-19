package com.fundoo_notes.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fundoo_notes.dto.reponse.LoginResponseDTO;
import com.fundoo_notes.dto.reponse.UserResponseDTO;
import com.fundoo_notes.dto.request.ForgetPasswordRequestDTO;
import com.fundoo_notes.dto.request.LoginRequestDTO;
import com.fundoo_notes.dto.request.RegisterRequestDTO;
import com.fundoo_notes.dto.request.ResetPasswordRequestDTO;
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

	public UserResponseDTO registerUser(@RequestBody RegisterRequestDTO registerRequest) {

		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			throw new UserAlreadyExistsException("Email already exists");
		}

		User user = new User();

		user.setName(registerRequest.getName());
		user.setEmail(registerRequest.getEmail());

		String encodePassword = passwordEncoder.encode(registerRequest.getPassword());

		user.setPassword(encodePassword);

		User savedUser = userRepository.save(user);

		return toResponse(savedUser);
	}

	public LoginResponseDTO loginUser(@RequestBody LoginRequestDTO loginRequest) {

		//authenticate email and password
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		
		//generate jwt
		String token = jwtService.generateToken(loginRequest.getEmail());
		
		// Find user
		
		User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new RuntimeException("User not found"));

		return new LoginResponseDTO("Login successfully",token);
	}

	public UserResponseDTO toResponse(User user) {

		UserResponseDTO response = new UserResponseDTO();

		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());

		return response;

	}

	@Override
	public String forgotPassword(ForgetPasswordRequestDTO request) {
		
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new UserNotFoundException("User not found with this email"));
		
		//generate reset token
		String resetToken = UUID.randomUUID().toString();
		
		//save token
		user.setResetToken(resetToken);
		
		//token valid for 15 min
		user.setResetTokenExpiry(LocalDateTime.now().plusMinutes(15));
		
		userRepository.save(user);
		
		return resetToken;
	}

	@Override
	public String resetPassword(ResetPasswordRequestDTO request) {
		
		User user = userRepository.findByResetToken(request.getToken()).orElseThrow(()-> new InvalidResetTokenException("Invalid reset token"));
		
		if(user.getResetTokenExpiry() == null ||
			user.getResetTokenExpiry().isBefore(LocalDateTime.now())){
				throw new ResetTokenExpiredException("Reset token has expired");
			}
		
		user.setPassword(passwordEncoder.encode(request.getNewPassword()));
		
		user.setResetToken(null);
		user.setResetTokenExpiry(null);
		
		userRepository.save(user);
		
		return "Password reset successfully";
		}
}

