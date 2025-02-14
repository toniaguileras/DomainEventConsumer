package com.aguilera.DomainEventConsumer.domain.shared;

import java.util.List;

public interface DomainEventPublisher {
  void publish(List<DomainEvent> events);
}
