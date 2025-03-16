package com.anuragkanwar.slackmessagebackend.model.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
