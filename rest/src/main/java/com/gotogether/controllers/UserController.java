package com.gotogether.controllers;

import com.gotogether.entity.EventPeople;
import com.gotogether.entity.User;
import com.gotogether.service.EventPeopleService;
import com.gotogether.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Optional<User> add(@RequestBody User user) { return userService.register(user); }
}
