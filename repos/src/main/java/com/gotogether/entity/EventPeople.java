package com.gotogether.entity;

import javax.persistence.*;

@Entity(name = "eventpeople")
public class EventPeople {
    private enum EventPeopleStatus {
        WAITFORACCEPT,
        ACCEPTED,
        REJECTED
    }
    private enum EventUsersPermissions {
        ADMIN,
        MODERATOR,
        MEMBER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private long eventId;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private EventPeopleStatus isGo;

    @Column(nullable = false)
    private EventUsersPermissions permission;

    public EventPeople() {

    }

    public EventPeople(long eventId, long userId, EventPeopleStatus isGo, EventUsersPermissions permission) {
        this.eventId = eventId;
        this.userId = userId;
        this.isGo = isGo;
        this.permission = permission;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public EventPeopleStatus getIsGo() {
        return isGo;
    }

    public void setIsGo(EventPeopleStatus isGo) {
        this.isGo = isGo;
    }

    public EventUsersPermissions getPermission() {
        return permission;
    }

    public void setPermission(EventUsersPermissions permission) {
        this.permission = permission;
    }

}
