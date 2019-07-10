package com.gotogether.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EventPeopleKey implements Serializable {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public EventPeopleKey() {
    }

    public EventPeopleKey(Event event, User user) {
        this.event = event;
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
