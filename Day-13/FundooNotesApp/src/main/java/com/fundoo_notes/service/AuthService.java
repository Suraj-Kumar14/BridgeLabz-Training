package com.fundoo_notes.service;

import com.fundoo_notes.dto.reponse.LoginResponseDTO;
import com.fundoo_notes.dto.reponse.UserResponseDTO;
import com.fundoo_notes.dto.request.ForgetPasswordRequestDTO;
import com.fundoo_notes.dto.request.LoginRequestDTO;
import com.fundoo_notes.dto.request.RegisterRequestDTO;
import com.fundoo_notes.dto.request.ResetPasswordRequestDTO;

public interface AuthService {

	UserResponseDTO registerUser(RegisterRequestDTO request);
	
	LoginResponseDTO loginUser(LoginRequestDTO loginRequest);
	
	String forgotPassword(ForgetPasswordRequestDTO request);
	
	String resetPassword(ResetPasswordRequestDTO request);
}
