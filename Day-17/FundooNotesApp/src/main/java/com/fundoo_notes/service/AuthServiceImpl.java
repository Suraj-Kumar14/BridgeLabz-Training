package com.fundoo_notes.service;

import java.time.LocalDateTime;

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
import com.fundoo_notes.dto.request.user.VerifyOtpRequestDTO;
import com.fundoo_notes.dto.response.LoginResponseDTO;
import com.fundoo_notes.dto.response.UserResponseDTO;
import com.fundoo_notes.entity.EmailOtp;
import com.fundoo_notes.entity.OtpPurpose;
import com.fundoo_notes.entity.User;
import com.fundoo_notes.exception.UserAlreadyExistsException;
import com.fundoo_notes.exception.UserNotFoundException;
import com.fundoo_notes.repository.EmailOtpRepository;
import com.fundoo_notes.repository.UserRepository;
import com.fundoo_notes.security.JwtService;
import com.fundoo_notes.service.email.EmailOtpService;
import com.fundoo_notes.service.email.EmailService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	private final EmailService emailService;
	private final EmailOtpService emailOtpService;
	private final EmailOtpRepository emailOtpRepository;
	
	@Override
	public UserResponseDTO registerUser(RegisterRequestDTO registerRequest) {

		if (userRepository.existsByEmail(registerRequest.getEmail())) {

			throw new UserAlreadyExistsException("Email already exists");
		}

		User user = new User();

		user.setName(registerRequest.getName());

		user.setEmail(registerRequest.getEmail());

		user.setPhone(registerRequest.getPhone());

		String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());

		user.setPassword(encodedPassword);

		user.setTokenVersion(0);

		user.setEmailVerified(false);

		User savedUser = userRepository.save(user);

		String otp = emailOtpService.generateAndSaveOtp(savedUser.getEmail(), OtpPurpose.REGISTRATION);

		emailService.sendRegistrationOtp(savedUser.getEmail(), otp);

		return toResponse(savedUser);
	}

	@Override
	public LoginResponseDTO loginUser(LoginRequestDTO loginRequest) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		User user = userRepository.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		if (!user.isEmailVerified()) {

			throw new RuntimeException("Please verify your email before login");
		}

		String token = jwtService.generateToken(loginRequest.getEmail(), user.getTokenVersion());

		return new LoginResponseDTO("Login successfully", token);
	}

	@Override
	public String forgotPassword(ForgetPasswordRequestDTO request) {

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new UserNotFoundException("User not found with this email"));

		String otp = emailOtpService.generateAndSaveOtp(user.getEmail(), OtpPurpose.PASSWORD_RESET);

		emailService.sendPasswordResetOtp(user.getEmail(), otp);

		return "Password reset OTP has been sent to your email";
	}

	@Override
	@Transactional
	public String resetPassword(ResetPasswordRequestDTO request) {

		emailOtpService.verifyOtp(request.getEmail(), request.getOtp(), OtpPurpose.PASSWORD_RESET);

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		user.setPassword(passwordEncoder.encode(request.getNewPassword()));

		user.setTokenVersion(user.getTokenVersion() + 1);

		userRepository.save(user);

		emailService.sendPasswordResetSuccess(user.getEmail());

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

	@Override
	@Transactional
	public void verifyOtp(VerifyOtpRequestDTO request) {

	    User user = userRepository
	            .findByEmail(request.getEmail())
	            .orElseThrow(() ->
	                    new UserNotFoundException(
	                            "User not found with email: "
	                                    + request.getEmail()
	                    )
	            );

	    EmailOtp emailOtp = emailOtpRepository
	            .findTopByEmailAndPurposeAndUsedFalseOrderByCreatedAtDesc(
	                    request.getEmail(),
	                    OtpPurpose.REGISTRATION
	            )
	            .orElseThrow(() ->
	                    new RuntimeException(
	                            "OTP not found or already used"
	                    )
	            );

	    if (emailOtp.getExpiresAt() == null) {
	        throw new RuntimeException(
	                "OTP expiry time is missing"
	        );
	    }

	    if (emailOtp.getExpiresAt()
	            .isBefore(LocalDateTime.now())) {

	        throw new RuntimeException(
	                "OTP has expired"
	        );
	    }

	    if (!emailOtp.getOtp()
	            .equals(request.getOtp())) {

	        throw new RuntimeException(
	                "Invalid OTP"
	        );
	    }

	    user.setEmailVerified(true);

	    userRepository.save(user);

	    emailOtp.setUsed(true);

	    emailOtpRepository.save(emailOtp);
	}
}
