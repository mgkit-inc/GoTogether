package com.gotogether.service.impl;

import com.gotogether.dto.TokenDTO;
import com.gotogether.entity.User;
import com.gotogether.repos.EventRepo;
import com.gotogether.repos.TokenRepo;
import com.gotogether.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class AuthServiceImpl implements AuthService {

    private final TokenRepo tokenRepo;

    @Autowired
    public AuthServiceImpl(TokenRepo tokenRepo) {
        this.tokenRepo = tokenRepo;
    }

    @Override
    public Optional<TokenDTO> GetTokens(User user) {
        return Optional.empty();
    }

}
