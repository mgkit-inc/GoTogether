package com.gotogether.service;

import com.gotogether.app.Profiles;
import com.gotogether.entity.EventPeople;
import org.springframework.context.annotation.Profile;

public interface EventPeopleService {

    EventPeople save(EventPeople eventPeople);

    @Profile(Profiles.DEV)
    void truncate();

}
