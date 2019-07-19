package com.example.demo.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonLoginSuccessHandler implements AuthenticationSuccessHandler {
    private JwtUserDetailsService jwtUserDetailsService;

    public JsonLoginSuccessHandler(JwtUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String token = jwtUserDetailsService.saveUserLoginInfo((UserDetails)authentication.getPrincipal());
        httpServletResponse.setHeader("Authorization", token);
    }
}
