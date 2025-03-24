package com.anuragkanwar.slackmessagebackend.model.dto.requests;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
