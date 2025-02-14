package com.aguilera.DomainEventConsumer.domain;

public interface TelemetryRecordedHandler {
  void handle(TelemetryRecordedEvent event);
}
