package com.aguilera.DomainEventConsumer.infraestructure;

import com.aguilera.DomainEventConsumer.application.RemoveOldTelemetries;
import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedHandler;
import com.aguilera.DomainEventConsumer.infraestructure.streams.handlers.DomainTelemetryRecordedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class InfraestructureConfiguration {
  @Bean
  public TelemetryRecordedHandler telemetryRecordedHandler(RemoveOldTelemetries removeOldTelemetries) {
    return new DomainTelemetryRecordedHandler(removeOldTelemetries);
  }
}
