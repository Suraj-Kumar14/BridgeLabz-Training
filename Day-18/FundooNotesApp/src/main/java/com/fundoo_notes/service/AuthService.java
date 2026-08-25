package com.fundoo_notes.service;

import com.fundoo_notes.dto.request.user.ForgetPasswordRequestDTO;
import com.fundoo_notes.dto.request.user.LoginRequestDTO;
import com.fundoo_notes.dto.request.user.RegisterRequestDTO;
import com.fundoo_notes.dto.request.user.ResetPasswordRequestDTO;
import com.fundoo_notes.dto.request.user.UserPatchRequestDTO;
import com.fundoo_notes.dto.request.user.VerifyOtpRequestDTO;
import com.fundoo_notes.dto.response.LoginResponseDTO;
import com.fundoo_notes.dto.response.UserResponseDTO;

public interface AuthService {

	UserResponseDTO registerUser(RegisterRequestDTO request);

	LoginResponseDTO loginUser(LoginRequestDTO loginRequest);

	String forgotPassword(ForgetPasswordRequestDTO request);

	String resetPassword(ResetPasswordRequestDTO request);

	UserResponseDTO updateUser(UserPatchRequestDTO request);

	void verifyOtp(VerifyOtpRequestDTO request);
	
	String resendVerificationOtp(String email);
	
}
