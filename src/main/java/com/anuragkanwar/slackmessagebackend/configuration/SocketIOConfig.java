package com.anuragkanwar.slackmessagebackend.configuration;

import com.anuragkanwar.slackmessagebackend.configuration.security.jwt.JwtUtils;
import com.anuragkanwar.slackmessagebackend.configuration.security.service.UserDetailServiceImpl;
import com.corundumstudio.socketio.AuthorizationResult;
import com.corundumstudio.socketio.SocketIOServer;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class SocketIOConfig {

    @Value("${socketio.host}")
    private String socketioHost;

    @Value("${socketio.port}")
    private int socketioPort;


    private final JwtUtils jwtUtils;
    private final UserDetailServiceImpl userDetailService;

    public SocketIOConfig( JwtUtils jwtUtils, UserDetailServiceImpl userDetailService) {
        this.jwtUtils = jwtUtils;
        this.userDetailService = userDetailService;
    }

    @Bean
    public SocketIOServer socketIOServer() {

        log.info("inside constructor");
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setPort(socketioPort);
        config.setHostname(socketioHost);
        config.setAuthorizationListener(handshakeData -> {

            if(log.isDebugEnabled()){
                log.debug("Handshake data : {}", handshakeData);
            }

            HttpHeaders headers = handshakeData.getHttpHeaders();
            String jwt = headers.get("Authorization");
            UserDetails userDetails = null;
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);
                userDetails = userDetailService.loadUserByUsername(username);
                Map<String, Object> authResult = new HashMap<>();
                authResult.put("user", userDetails);
                return new AuthorizationResult(true, authResult);
            }
            return AuthorizationResult.FAILED_AUTHORIZATION;
        });

        return new SocketIOServer(config);
    }

}
