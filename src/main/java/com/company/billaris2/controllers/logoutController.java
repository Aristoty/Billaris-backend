package com.company.billaris2.controllers;

import com.company.billaris2.services.LogoutService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class logoutController implements LogoutSuccessHandler {

    @Autowired
    private LogoutService logoutService;

    @GetMapping
    public String logout(){
        logoutService.logout(null, null, null);
        return "redirect:/login";
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logoutService.logout(request, response, authentication);


    }
}
