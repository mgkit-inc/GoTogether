package com.gotogether.service;

import com.gotogether.dto.TokenDTO;
import com.gotogether.entity.User;

import java.util.Optional;

public interface AuthService {

    Optional<TokenDTO> GetTokens(User user);

}
