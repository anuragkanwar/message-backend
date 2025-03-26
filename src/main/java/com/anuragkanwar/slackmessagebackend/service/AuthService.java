package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.dto.request.LoginRequest;
import com.anuragkanwar.slackmessagebackend.model.dto.request.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> login(LoginRequest loginRequest);
    ResponseEntity<?> signup(SignupRequest signupRequest);
}
