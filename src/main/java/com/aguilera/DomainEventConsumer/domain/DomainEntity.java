package com.aguilera.DomainEventConsumer.domain;

import com.aguilera.DomainEventConsumer.domain.shared.DomainEvent;

import java.util.ArrayList;

public class DomainEntity {
   private ArrayList<DomainEvent> domainEvents = new ArrayList<>();

  public ArrayList<DomainEvent> getDomainEvents() {
    return domainEvents;
  }

  public void addDomainEvent(DomainEvent domainEvent) {
    domainEvents.add(domainEvent);
  }
}
