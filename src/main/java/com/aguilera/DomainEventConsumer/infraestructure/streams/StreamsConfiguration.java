package com.aguilera.DomainEventConsumer.infraestructure.streams;

import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedHandler;
import com.aguilera.DomainEventConsumer.domain.shared.DomainEventPublisher;
import com.aguilera.DomainEventConsumer.infraestructure.streams.consumers.SpringDomainEventsConsumer;
import com.aguilera.DomainEventConsumer.infraestructure.streams.publishers.SpringDomainEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StreamsConfiguration {
  @Bean
  public DomainEventPublisher domainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    return new SpringDomainEventPublisher(applicationEventPublisher);
  }

  @Bean
  public SpringDomainEventsConsumer springDomainEventsConsumer(TelemetryRecordedHandler telemetryRecordedHandler) {
    return new SpringDomainEventsConsumer(telemetryRecordedHandler);
  }
}
