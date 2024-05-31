// path: src/main/java/com/openclassrooms/mddapi/controller/AuthController.java
package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.dto.DBUserDTO;
import com.openclassrooms.mddapi.security.service.JWTService;
import com.openclassrooms.mddapi.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JWTService jwtService;
    private final AuthService authService;

    @Autowired
    public AuthController(JWTService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/token")
    public String getToken(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        String token = authService.login(username, password);
        Map<String, String> response = new HashMap<>();
        if (token != null) {
            response.put("status", "success");
            response.put("token", token);
        } else {
            response.put("status", "fail");
            response.put("message", "Invalid credentials");
        }
        return response;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody DBUserDTO registerData) {
        String token = authService.register(registerData);
        Map<String, String> response = new HashMap<>();
        if (token != null) {
            response.put("status", "success");
            response.put("token", token);
        } else {
            response.put("status", "fail");
            response.put("message", "Username already exists");
        }
        return response;
    }
}
