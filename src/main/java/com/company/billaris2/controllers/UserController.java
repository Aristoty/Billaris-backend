package com.company.billaris2.controllers;

import com.company.billaris2.entities.User;
import com.company.billaris2.models.JwtResponse;
import com.company.billaris2.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/current-user")
    public ResponseEntity<JwtResponse> getCurrentUser(Principal principal){
        var currentUser = userService.getCurrentUser(principal);
        if (currentUser != null){
            return ResponseEntity.ok(currentUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/current-username")
    public String getUsername(Principal principal){
        return principal.getName();
    }
}
