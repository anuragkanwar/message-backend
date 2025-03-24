package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.dto.requests.LoginRequest;
import com.anuragkanwar.slackmessagebackend.model.dto.requests.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> login(LoginRequest loginRequest);
    ResponseEntity<?> signup(SignupRequest signupRequest);
}
