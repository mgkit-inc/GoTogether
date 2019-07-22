package com.gotogether.controllers;

import com.gotogether.entity.EventPeople;
import com.gotogether.service.EventPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event-people")
public class EventPeopleController {

    @Autowired
    EventPeopleService eventPeopleService;

    @PostMapping
    public EventPeople add(@RequestBody EventPeople eventPeople) {
        return eventPeopleService.save(eventPeople);
    }

}
