package com.gotogether.service.impl;

import com.gotogether.entity.User;
import com.gotogether.repos.UserRepo;
import com.gotogether.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Optional<User> register(User user) {
        return Optional.of(userRepo.save(user));
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void truncate() {
        userRepo.deleteAll();
    }

}
