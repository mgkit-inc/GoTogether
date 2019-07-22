package com.gotogether.entity;

import java.util.Optional;

public enum EventUsersPermissions {

    ADMIN(0),
    MODERATOR(1),
    MEMBER(2);

    private int id;

    EventUsersPermissions(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<EventUsersPermissions> parse(int permissionId) {
        EventUsersPermissions permission = null;
        for (EventUsersPermissions item : EventUsersPermissions.values()) {
            if (item.getId() == permissionId) {
                permission = item;
                break;
            }
        }
        return Optional.ofNullable(permission);
    }

}
