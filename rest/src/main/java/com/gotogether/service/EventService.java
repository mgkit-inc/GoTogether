package com.gotogether.service;

import com.gotogether.app.Profiles;
import com.gotogether.entity.Event;
import org.springframework.context.annotation.Profile;

import java.util.List;

public interface EventService {

    Event save(Event event);

    List<Event> getByName(String name);

    @Profile(Profiles.DEV)
    void truncate();

}
