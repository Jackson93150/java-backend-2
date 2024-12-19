package com.example.auth.controller;
import com.example.auth.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/token/{name}")
    public String generateToken(@PathVariable String name) {
        System.out.println(name);
        return jwtService.generateToken(name);
    }
}
