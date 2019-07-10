package com.gotogether.entity;

import java.util.Optional;

public enum EventPeopleStatus {

    WAIT_FOR_ACCEPT(0),
    ACCEPTED(1),
    REJECTED(2);

    private int id;

    EventPeopleStatus() {
    }

    EventPeopleStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<EventPeopleStatus> parse(int statusId) {
        EventPeopleStatus status = null;
        for (EventPeopleStatus item : EventPeopleStatus.values()) {
            if (item.getId() == statusId) {
                status = item;
                break;
            }
        }
        return Optional.ofNullable(status);
    }
}
