package com.gotogether.controllers;

import com.gotogether.dto.TokenDTO;
import com.gotogether.entity.User;
import com.gotogether.exceptions.BadRequestException;
import com.gotogether.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<TokenDTO> GetUserTokens(@RequestBody User user) throws BadRequestException {
        return authService.GetTokens(user.getUsername(), user.getPassword());
    }



}
