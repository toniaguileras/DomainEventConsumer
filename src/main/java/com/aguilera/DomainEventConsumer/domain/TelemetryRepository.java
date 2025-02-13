package com.aguilera.DomainEventConsumer.domain;

public interface TelemetryRepository {
  void save(Telemetry telemetry);
}
