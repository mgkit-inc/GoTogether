package com.gotogether.runners;

import com.gotogether.app.Profiles;
import com.gotogether.entity.*;
import com.gotogether.service.EventPeopleService;
import com.gotogether.service.EventService;
import com.gotogether.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(Profiles.DEV)
public class DataLoader implements ApplicationRunner {

    private final EventPeopleService eventPeopleService;
    private final EventService eventService;
    private final UserService userService;

    @Autowired
    public DataLoader(EventPeopleService eventPeopleService,
                      EventService eventService,
                      UserService userService) {
        this.eventPeopleService = eventPeopleService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) {
        addUsers();
        addEvents();
        addUserEventsInfo();
    }

    private void addUsers() {
        userService.truncate();
        userService.register(new User("user1", "email1@email.com", "pass1", true));
        userService.register(new User("user2", "email2@email.com", "pass2", true));
        userService.register(new User("user3", "email3@email.com", "pass3", true));
        userService.register(new User("user4", "email4@email.com", "pass4", true));
        userService.register(new User("user5", "email5@email.com", "pass5", true));
    }

    private void addEvents() {
        eventService.truncate();
        eventService.save(
                new Event(
                        "event1",
                        Theme.CINEMA,
                        "moscow",
                        123L,
                        100,
                        userService.getByUsername("user1").orElseThrow(() -> new RuntimeException("no user")),
                        EventVisibility.VISIBLE,
                        EventPrivacy.ALL
                )
        );

        eventService.save(
                new Event(
                        "event2",
                        Theme.ENTERTAINMENT,
                        "moscow",
                        123L,
                        100,
                        userService.getByUsername("user2").orElseThrow(() -> new RuntimeException("no user")),
                        EventVisibility.VISIBLE,
                        EventPrivacy.ALL
                )
        );
    }

    private void addUserEventsInfo() {
        eventPeopleService.truncate();
        eventPeopleService.save(
                new EventPeople(
                        new EventPeopleKey(
                                eventService.getByName("event1").get(0),
                                userService.getByUsername("user1").get()
                        ),
                        EventUsersPermissions.MEMBER,
                        EventPeopleStatus.REJECTED
                )
        );
    }
}
