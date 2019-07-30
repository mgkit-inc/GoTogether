package com.gotogether.service.impl;

import com.gotogether.config.AuthConfig;
import com.gotogether.dto.TokenDTO;
import com.gotogether.entity.User;
import com.gotogether.exceptions.BadRequestException;
import com.gotogether.repos.TokenRepo;
import com.gotogether.service.AuthService;
import com.gotogether.service.UserService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.*;

@Component
public class AuthServiceImpl implements AuthService {

    private final TokenRepo tokenRepo;
    private final AuthConfig authConfig;

    @Autowired
    public AuthServiceImpl(TokenRepo tokenRepo, AuthConfig authConfig) {
        this.tokenRepo = tokenRepo;
        this.authConfig = authConfig;
    }

    @Autowired
    private UserService userService;

    @Override
    public Optional<TokenDTO> GetTokens(String userName, String password) throws BadRequestException {
        if (userName == null || password == null)
            throw new BadRequestException("Wrong username or password!");
        User user;
        try {
            user = userService.getByUsername(userName).get();
        } catch(Exception ex) {
            throw new BadRequestException("Wrong username or password!");
        }
        Map<String, Object> tokenData = new HashMap<>();
        if (password.equals(user.getPassword())) {
            tokenData.put("clientType", "user");
            tokenData.put("userID", Long.toString(user.getId()));
            tokenData.put("username", user.getUsername());
            tokenData.put("token_create_date", new Date().getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 100);
            tokenData.put("token_expiration_date", calendar.getTime());
            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(tokenData);
            TokenDTO tokens = new TokenDTO(
                    jwtBuilder.signWith(SignatureAlgorithm.HS512, authConfig.getAccessKey() + userName).compact(),
                    jwtBuilder.signWith(SignatureAlgorithm.HS512, authConfig.getRefreshKey() + userName).compact()
            );
            return Optional.ofNullable(tokens);
        }
        return null;
    }
}
