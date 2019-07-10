package com.gotogether.entity;

import java.util.Optional;

public enum EventVisibility {

    HIDDEN(0),
    VISIBLE(1);

    private int id;

    EventVisibility(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<EventVisibility> parse(int visibilityId) {
        EventVisibility visibility = null;
        for (EventVisibility item : EventVisibility.values()) {
            if (item.getId() == visibilityId) {
                visibility = item;
                break;
            }
        }
        return Optional.ofNullable(visibility);
    }
}
