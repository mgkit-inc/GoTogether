package com.gotogether.entity;

import java.util.Optional;

public enum EventPrivacy {

    ALL(0),
    INVITED(1);

    private int id;

    EventPrivacy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<EventPrivacy> parse(int privacyId) {
        EventPrivacy privacy = null;
        for (EventPrivacy item : EventPrivacy.values()) {
            if (item.getId() == privacyId) {
                privacy = item;
                break;
            }
        }
        return Optional.ofNullable(privacy);
    }

}
