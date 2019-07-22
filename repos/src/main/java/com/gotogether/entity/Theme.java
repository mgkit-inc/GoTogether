package com.gotogether.entity;

import java.util.Optional;

public enum Theme {

    ENTERTAINMENT(0),
    CINEMA(1),
    MEETUP(2);

    private int id;

    Theme(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<Theme> parse(int themeId) {
        Theme theme = null;
        for (Theme item : Theme.values()) {
            if (item.getId() == themeId) {
                theme = item;
                break;
            }
        }
        return Optional.ofNullable(theme);
    }

}
