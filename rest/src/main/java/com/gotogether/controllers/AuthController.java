package com.gotogether.controllers;

import com.gotogether.dto.TokenDTO;
import com.gotogether.entity.User;
import com.gotogether.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping
    public Optional<TokenDTO> get(@RequestBody User user) { return authService.GetTokens(user); }

}
