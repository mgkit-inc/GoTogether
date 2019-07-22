package com.gotogether.service.impl;

import com.gotogether.entity.Event;
import com.gotogether.repos.EventRepo;
import com.gotogether.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventServiceImpl implements EventService {

    private final EventRepo eventRepo;

    @Autowired
    public EventServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public Event save(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public void truncate() {
        eventRepo.deleteAll();
    }

    @Override
    public List<Event> getByName(String name) {
        return eventRepo.findByName(name);
    }
}
