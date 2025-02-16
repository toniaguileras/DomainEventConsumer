package com.aguilera.DomainEventConsumer.domain.exceptions;

public class AlreadyExistsTelemetryException extends RuntimeException {
  public AlreadyExistsTelemetryException() {
    super("This telemetry already exists.");
  }
}
