package com.gotogether.service.impl;

import com.gotogether.entity.EventPeople;
import com.gotogether.repos.EventPeopleRepo;
import com.gotogether.service.EventPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventPeopleServiceImpl implements EventPeopleService {

    private final EventPeopleRepo eventPeopleRepo;

    @Autowired
    public EventPeopleServiceImpl(EventPeopleRepo eventPeopleRepo) {
        this.eventPeopleRepo = eventPeopleRepo;
    }

    @Override
    public EventPeople save(EventPeople eventPeople) {
        return eventPeopleRepo.save(eventPeople);
    }

    @Override
    public void truncate() {
        eventPeopleRepo.deleteAll();
    }
}
