package com.anuragkanwar.slackmessagebackend.utils;

import com.anuragkanwar.slackmessagebackend.configuration.security.service.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class Utils {
    public static String getCurrentUsernameFromAuthentication(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            } else {
                return principal.toString();
            }
        }
        return null;
    }


    public static Long getCurrentUserIdFromAuthentication(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetailsImpl) {
                return ((UserDetailsImpl) principal).getId();
            } else {
                return null;
            }
        }
        return null;
    }


    public Long getCurrentWorkspaceIdFromCookie() {

    }

}
