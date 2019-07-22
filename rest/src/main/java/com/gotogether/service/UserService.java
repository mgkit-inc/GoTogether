package com.gotogether.service;

import com.gotogether.app.Profiles;
import com.gotogether.entity.User;
import org.springframework.context.annotation.Profile;

import java.util.Optional;

public interface UserService {

    Optional<User> register(User user);

    Optional<User> getByUsername(String username);

    @Profile(Profiles.DEV)
    void truncate();

}
