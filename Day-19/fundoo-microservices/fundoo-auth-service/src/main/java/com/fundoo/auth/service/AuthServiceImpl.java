package com.fundoo.auth.service;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.auth.dto.request.ForgetPasswordRequestDTO;
import com.fundoo.auth.dto.request.LoginRequestDTO;
import com.fundoo.auth.dto.request.RegisterRequestDTO;
import com.fundoo.auth.dto.request.ResetPasswordRequestDTO;
import com.fundoo.auth.dto.request.UserPatchRequestDTO;
import com.fundoo.auth.dto.request.VerifyOtpRequestDTO;
import com.fundoo.auth.dto.response.LoginResponseDTO;
import com.fundoo.auth.dto.response.UserResponseDTO;
import com.fundoo.auth.entity.OtpPurpose;
import com.fundoo.auth.entity.User;
import com.fundoo.auth.exception.EmailAlreadyVerifiedException;
import com.fundoo.auth.exception.EmailNotVerifiedException;
import com.fundoo.auth.exception.UserAlreadyExistsException;
import com.fundoo.auth.exception.UserNotFoundException;
import com.fundoo.auth.messaging.NotificationProducer;
import com.fundoo.auth.repository.UserRepository;
import com.fundoo.auth.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	private final JwtService jwtService;

	private final EmailOtpService emailOtpService;

	private final NotificationProducer notificationProducer;

	private final RedisTokenService redisTokenService;

	@Override
	@Transactional
	public UserResponseDTO registerUser(RegisterRequestDTO request) {

		String email = request.getEmail().trim().toLowerCase();

		Optional<User> existingUser = userRepository.findByEmail(email);

		/*
		 * CASE 1: Email already exists.
		 */
		if (existingUser.isPresent()) {

			User user = existingUser.get();

			/*
			 * Existing user but email is not verified.
			 *
			 * Instead of creating another user, generate a new OTP.
			 */
			if (!user.isEmailVerified()) {

				String otp = emailOtpService.generateAndSaveOtp(user.getEmail(), OtpPurpose.REGISTRATION);

				notificationProducer.sendRegistrationOtp(user.getEmail(), otp);

				return toResponse(user);
			}

			/*
			 * Existing verified user.
			 */
			throw new UserAlreadyExistsException("Email already exists");
		}

		User user = new User();

		user.setName(request.getName());

		user.setEmail(email);

		user.setPhone(request.getPhone());

		user.setPassword(passwordEncoder.encode(request.getPassword()));

		user.setTokenVersion(0);

		user.setEmailVerified(false);

		user.setEnabled(false);

		/*
		 * Role automatically becomes USER because of entity default value.
		 */

		User savedUser = userRepository.save(user);

		// Generate registration OTP
		String otp = emailOtpService.generateAndSaveOtp(savedUser.getEmail(), OtpPurpose.REGISTRATION);

		// Publish notification event
		notificationProducer.sendRegistrationOtp(savedUser.getEmail(), otp);

		return toResponse(savedUser);
	}

	@Override
	@Transactional
	public void verifyOtp(VerifyOtpRequestDTO request) {

		String email = request.getEmail().trim().toLowerCase();

		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));

		if (user.isEmailVerified()) {

			throw new IllegalStateException("Email is already verified");
		}

		/*
		 * EmailOtpService handles:
		 *
		 * 1. OTP exists 2. OTP belongs to correct purpose 3. OTP is not used 4. OTP is
		 * not expired 5. OTP value is correct
		 */
		emailOtpService.verifyOtp(email, request.getOtp(), OtpPurpose.REGISTRATION);

		/*
		 * OTP successfully verified.
		 */
		user.setEmailVerified(true);

		user.setEnabled(true);

		userRepository.save(user);
	}

	@Override
	@Transactional
	public String resendVerificationOtp(String email) {

		email = email.trim().toLowerCase();

		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User not found with this email"));

		if (user.isEmailVerified()) {

			throw new EmailAlreadyVerifiedException("Email is already verified");
		}

		String otp = emailOtpService.generateAndSaveOtp(user.getEmail(), OtpPurpose.REGISTRATION);

		notificationProducer.sendRegistrationOtp(user.getEmail(), otp);

		return "New verification OTP has been sent to your email";
	}

	@Override
	public LoginResponseDTO loginUser(LoginRequestDTO loginRequest) {

		User user = userRepository.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new BadCredentialsException("Invalid email or password"));

		if (!user.isEmailVerified()) {

			throw new EmailNotVerifiedException("Email is not verified. Please verify your email before login.");
		}

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		String token = jwtService.generateToken(loginRequest.getEmail(), user.getTokenVersion());

		// Store JWT in Redis
		redisTokenService.saveToken(token, user.getEmail(), jwtService.getExpiration());

		return new LoginResponseDTO("Login successfully", token);
	}

	@Override
	@Transactional
	public String forgotPassword(ForgetPasswordRequestDTO request) {

		String email = request.getEmail().trim().toLowerCase();

		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User not found with this email"));

		/*
		 * Generate PASSWORD_RESET OTP.
		 */
		String otp = emailOtpService.generateAndSaveOtp(user.getEmail(), OtpPurpose.PASSWORD_RESET);

		/*
		 * Send notification asynchronously.
		 */
		notificationProducer.sendPasswordResetOtp(user.getEmail(), otp);

		return "Password reset OTP has been sent to your email";
	}

	@Override
	@Transactional
	public String resetPassword(ResetPasswordRequestDTO request) {

		String email = request.getEmail().trim().toLowerCase();

		/*
		 * First verify OTP.
		 */
		emailOtpService.verifyOtp(email, request.getOtp(), OtpPurpose.PASSWORD_RESET);

		User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));

		/*
		 * Update password.
		 */
		user.setPassword(passwordEncoder.encode(request.getNewPassword()));

		/*
		 * IMPORTANT:
		 *
		 * Incrementing tokenVersion means previously issued JWTs become invalid when
		 * JWT validation checks this version.
		 */
		user.setTokenVersion(user.getTokenVersion() + 1);

		userRepository.save(user);

		/*
		 * Notify user asynchronously.
		 */
		notificationProducer.sendPasswordResetSuccess(user.getEmail());

		return "Password reset successfully";
	}

	@Override
	@Transactional
	public UserResponseDTO updateUser(UserPatchRequestDTO request) {

		User currentUser = getCurrentUser();

		if (request.getName() != null && !request.getName().isBlank()) {

			currentUser.setName(request.getName());
		}

		if (request.getPhone() != null && !request.getPhone().isBlank()) {

			currentUser.setPhone(request.getPhone());
		}

		User updatedUser = userRepository.save(currentUser);

		return toResponse(updatedUser);
	}

	private User getCurrentUser() {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	private UserResponseDTO toResponse(User user) {

		UserResponseDTO response = new UserResponseDTO();

		response.setId(user.getId());

		response.setName(user.getName());

		response.setEmail(user.getEmail());

		response.setPhone(user.getPhone());

		return response;
	}

	@Override
	public void logout(String token) {
		redisTokenService.deleteToken(token);
		
	}
}