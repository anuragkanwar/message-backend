package com.anuragkanwar.slackmessagebackend.model.dto;

import com.anuragkanwar.slackmessagebackend.model.domain.Workspace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private Long id;
    private String username;
    private String email;
    private String jwt;
    private Set<String> roles;
}