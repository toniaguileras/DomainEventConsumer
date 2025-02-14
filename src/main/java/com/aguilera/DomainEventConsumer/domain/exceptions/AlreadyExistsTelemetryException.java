package com.aguilera.DomainEventConsumer.domain.exceptions;

import org.springframework.dao.DataAccessException;

public class AlreadyExistsTelemetryException extends RuntimeException {
  public AlreadyExistsTelemetryException() {
    super("This telemetry already exists.");
  }
}
