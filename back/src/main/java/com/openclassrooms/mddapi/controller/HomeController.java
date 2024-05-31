//path: back/src/main/java/com/openclassrooms/mddapi/controller/HomeController.java
package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.security.service.JWTService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    public JWTService jwtService;

    public HomeController(JWTService jwtService){
        this.jwtService = jwtService;
    }

    @GetMapping
    public String home() {
        return "Welcome to the MDD API!";
    }

    @PostMapping("/login")
    public String getToken(Authentication authentication){
        String token = jwtService.generateToken(authentication);
        return token;
    }

}
