package com.gotogether.entity;

import javax.persistence.*;

@Entity(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "theme_id")
    private int themeId;

    @Column
    private String location;

    @Column
    private long timestamp;

    @Column(name = "max_people")
    private Integer maxPeople;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "event_visibility_id")
    private int visibilityId;

    @Column(name = "event_privacy_id")
    private int eventPrivacyId;

    public Event() {
    }

    public Event(String name,
                 Theme theme,
                 String location,
                 long timestamp,
                 int maxPeople,
                 User owner,
                 EventVisibility visibility,
                 EventPrivacy eventPrivacy) {
        this.name = name;
        this.themeId = theme.getId();
        this.location = location;
        this.timestamp = timestamp;
        this.maxPeople = maxPeople;
        this.owner = owner;
        this.visibilityId = visibility.getId();
        this.eventPrivacyId = eventPrivacy.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theme getTheme() {
        return Theme.parse(themeId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown theme id: " + visibilityId));
    }

    public void setTheme(Theme theme) {
        this.themeId = theme.getId();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public EventVisibility getVisibility() {
        return EventVisibility.parse(visibilityId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown visibility id: " + visibilityId));
    }

    public void setVisibility(EventVisibility visibility) {
        this.visibilityId = visibility.getId();
    }

    public EventPrivacy getEventPrivacy() {
        return EventPrivacy.parse(eventPrivacyId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown privacy id: " + eventPrivacyId));
    }

    public void setEventPrivacy(EventPrivacy eventPrivacy) {
        this.eventPrivacyId = eventPrivacy.getId();
    }
}
