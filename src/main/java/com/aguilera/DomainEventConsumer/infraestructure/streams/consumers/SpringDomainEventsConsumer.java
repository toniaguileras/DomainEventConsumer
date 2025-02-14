package com.aguilera.DomainEventConsumer.infraestructure.streams.consumers;

import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedEvent;
import com.aguilera.DomainEventConsumer.domain.shared.DomainEvent;
import com.aguilera.DomainEventConsumer.infraestructure.streams.DomainEventAggregate;
import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SpringDomainEventsConsumer {
  @Autowired
  private TelemetryRecordedHandler telemetryRecordedHandler;

  public SpringDomainEventsConsumer(TelemetryRecordedHandler telemetryRecordedHandler) {
    this.telemetryRecordedHandler = telemetryRecordedHandler;
  }

  @Async
  @EventListener
  public void consume(DomainEventAggregate domainEventAggregate) {
    DomainEvent event = domainEventAggregate.getSource();
    if (event instanceof TelemetryRecordedEvent) {
      telemetryRecordedHandler.handle((TelemetryRecordedEvent) event);
    }
  }
}
