package com.lizzaraga.eventer.subscription;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EventSubscriptionId {

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "event_id")
    private Long eventId;
}
