package com.aguilera.DomainEventConsumer.application;

import com.aguilera.DomainEventConsumer.application.telemetry.CreateTelemetry;
import com.aguilera.DomainEventConsumer.application.telemetry.FindTelemetry;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import com.aguilera.DomainEventConsumer.domain.shared.DomainEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
  @Bean
  public CreateTelemetry createTelemetry(TelemetryRepository telemetryRepository, DomainEventPublisher domainEventPublisher) {
    return new CreateTelemetry(telemetryRepository, domainEventPublisher);
  }
  @Bean
  public FindTelemetry findTelemetry(TelemetryRepository telemetryRepository) {
    return new FindTelemetry(telemetryRepository);
  }
}
