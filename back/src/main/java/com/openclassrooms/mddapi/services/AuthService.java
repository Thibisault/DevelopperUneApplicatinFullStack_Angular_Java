package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.DBUserDTO;
import com.openclassrooms.mddapi.security.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    DBUserService dbUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    private final JWTService jwtService;

    public AuthService(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    public String login(String username, String password) {
        if (dbUserService.readByUsername(username).isPresent()) {
            return jwtService.generateToken(new UsernamePasswordAuthenticationToken("user", "password"));
        }
        return null;
    }

    public String register(DBUserDTO registerData) {
        if (dbUserService.readByUsername(registerData.getUsername()).isPresent()) {
            return null; // Username already exists
        }
        registerData.setPassword(passwordEncoder.encode(registerData.getPassword()));
        DBUserDTO newUser = dbUserService.create(registerData);
        return jwtService.generateToken(new UsernamePasswordAuthenticationToken(newUser.getUsername(), registerData.getPassword()));
    }

    public String generateTokenForUpdatedUser(String username) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null);
        return jwtService.generateToken(authentication);
    }
}
