package com.gotogether.entity;

import javax.persistence.*;

@Entity(name = "event_people")
public class EventPeople {

    @Id
    @Embedded
    private
    EventPeopleKey key;

    @Column(name = "permission_id")
    private int permissionId;

    @Column(name = "status_id")
    private int statusId;

    public EventPeople() {
    }

    public EventPeople(EventPeopleKey key, EventUsersPermissions permission, EventPeopleStatus status) {
        this.key = key;
        this.permissionId = permission.getId();
        this.statusId = status.getId();
    }

    public EventPeopleKey getKey() {
        return key;
    }

    public void setKey(EventPeopleKey key) {
        this.key = key;
    }

    public EventPeopleStatus getStatus() {
        return EventPeopleStatus.parse(statusId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown status id: " + statusId));
    }

    public void setStatus(EventPeopleStatus status) {
        this.statusId = status.getId();
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public EventUsersPermissions getPermission() {
        return EventUsersPermissions.parse(permissionId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown permission id: " + statusId));
    }

    public void setEventUsersPermissions(EventUsersPermissions permission) {
        this.permissionId = permission.getId();
    }
}
