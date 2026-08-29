package com.fundoo.auth.service;

import com.fundoo.auth.dto.request.ForgetPasswordRequestDTO;
import com.fundoo.auth.dto.request.LoginRequestDTO;
import com.fundoo.auth.dto.request.RegisterRequestDTO;
import com.fundoo.auth.dto.request.ResetPasswordRequestDTO;
import com.fundoo.auth.dto.request.UserPatchRequestDTO;
import com.fundoo.auth.dto.request.VerifyOtpRequestDTO;
import com.fundoo.auth.dto.response.LoginResponseDTO;
import com.fundoo.auth.dto.response.UserResponseDTO;

public interface AuthService {

	UserResponseDTO registerUser(RegisterRequestDTO request);

	void verifyOtp(VerifyOtpRequestDTO request);

	String resendVerificationOtp(String email);

	LoginResponseDTO loginUser(LoginRequestDTO request);

	String forgotPassword(ForgetPasswordRequestDTO request);

	String resetPassword(ResetPasswordRequestDTO request);

	UserResponseDTO updateUser(UserPatchRequestDTO request);
	
	void logout(String token);
}