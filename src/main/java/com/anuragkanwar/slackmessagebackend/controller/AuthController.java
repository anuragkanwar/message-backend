package com.anuragkanwar.slackmessagebackend.controller;

import com.anuragkanwar.slackmessagebackend.configuration.security.jwt.JwtUtils;
import com.anuragkanwar.slackmessagebackend.configuration.security.service.UserDetailsImpl;
import com.anuragkanwar.slackmessagebackend.model.domain.Role;
import com.anuragkanwar.slackmessagebackend.model.domain.User;
import com.anuragkanwar.slackmessagebackend.model.dto.LoginRequest;
import com.anuragkanwar.slackmessagebackend.model.dto.LoginResponse;
import com.anuragkanwar.slackmessagebackend.model.dto.SignupRequest;
import com.anuragkanwar.slackmessagebackend.model.enums.RoleType;
import com.anuragkanwar.slackmessagebackend.repository.RoleRepository;
import com.anuragkanwar.slackmessagebackend.repository.UserRepository;
import com.anuragkanwar.slackmessagebackend.service.RoleService;
import com.anuragkanwar.slackmessagebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {

            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        } catch (AuthenticationException e) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad Creds");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        String jwt = jwtUtils.generateTokenFromUserDetails(userDetails);
        return ResponseEntity.ok(new LoginResponse(
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                jwt,
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        // Create new user's account
        User user = User.builder().
                username(signUpRequest.getUsername())
                .email(signUpRequest.getEmail())
                .password(encoder.encode(signUpRequest.getPassword()))
                .build();

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByRole((RoleType.USER)));
        user.setRoles(roles);
        userService.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

}
