package com.aguilera.DomainEventConsumer.infraestructure.streams.publishers;

import com.aguilera.DomainEventConsumer.domain.shared.DomainEvent;
import com.aguilera.DomainEventConsumer.domain.shared.DomainEventPublisher;
import com.aguilera.DomainEventConsumer.infraestructure.streams.DomainEventAggregate;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

public class SpringDomainEventPublisher implements DomainEventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;

  public SpringDomainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Override
  public void publish(List<DomainEvent> events) {
    for (DomainEvent event : events) {
      applicationEventPublisher.publishEvent(new DomainEventAggregate(event));
    }
  }
}
