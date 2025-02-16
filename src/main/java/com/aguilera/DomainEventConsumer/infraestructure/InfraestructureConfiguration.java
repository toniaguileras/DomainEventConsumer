package com.aguilera.DomainEventConsumer.infraestructure;

import com.aguilera.DomainEventConsumer.application.telemetry.RemoveOldTelemetries;
import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedHandler;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import com.aguilera.DomainEventConsumer.infraestructure.repository.H2TelemetryRepository;
import com.aguilera.DomainEventConsumer.infraestructure.streams.handlers.DomainTelemetryRecordedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class InfraestructureConfiguration {
  @Bean
  public TelemetryRecordedHandler telemetryRecordedHandler(RemoveOldTelemetries removeOldTelemetries) {
    return new DomainTelemetryRecordedHandler(removeOldTelemetries);
  }
  @Bean
  public TelemetryRepository telemetryRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    return new H2TelemetryRepository(jdbcTemplate);
  }

}
