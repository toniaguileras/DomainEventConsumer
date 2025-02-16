package com.aguilera.DomainEventConsumer.infraestructure.streams.consumers;

import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedEvent;
import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedHandler;
import com.aguilera.DomainEventConsumer.infraestructure.streams.DomainEventAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.EventObject;

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
   if(domainEventAggregate != null){
     Object eventSource = ((EventObject) domainEventAggregate).getSource();
     if (eventSource instanceof TelemetryRecordedEvent telemetryEvent) {
       telemetryRecordedHandler.handle(telemetryEvent);
     }
   }
  }
}
