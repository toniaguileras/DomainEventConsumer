package com.aguilera.DomainEventConsumer.infraestructure.streams;

import com.aguilera.DomainEventConsumer.domain.shared.DomainEvent;
import org.springframework.context.ApplicationEvent;

public class DomainEventAggregate extends ApplicationEvent {
  private DomainEvent source;

  public DomainEventAggregate(DomainEvent source) {
    super(source);
  }

  @Override
  public DomainEvent getSource() {
    return source;
  }
}
