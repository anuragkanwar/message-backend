package com.anuragkanwar.slackmessagebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String username;
    private String email;
    private String password;
}
