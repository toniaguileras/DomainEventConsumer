package com.aguilera.DomainEventConsumer.domain.shared;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public abstract class DomainEvent {
  private String aggregateId;
  String id = UUID.randomUUID().toString();
  OffsetDateTime occurredOn = OffsetDateTime.now(ZoneOffset.UTC);

  public DomainEvent(String aggregateId) {
    this.aggregateId = aggregateId;
  }

  public String getAggregateId() {
    return aggregateId;
  }

  public void setAggregateId(String aggregateId) {
    this.aggregateId = aggregateId;
  }
}
