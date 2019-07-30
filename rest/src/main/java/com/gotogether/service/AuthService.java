package com.gotogether.service;

import com.gotogether.dto.TokenDTO;
import com.gotogether.entity.User;
import com.gotogether.exceptions.BadRequestException;

import java.util.Optional;

public interface AuthService {

    Optional<TokenDTO> GetTokens(String userName, String password) throws BadRequestException;

}
