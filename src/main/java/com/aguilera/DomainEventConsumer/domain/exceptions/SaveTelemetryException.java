package com.aguilera.DomainEventConsumer.domain.exceptions;

import org.springframework.dao.DataAccessException;

public class SaveTelemetryException extends RuntimeException {
  public SaveTelemetryException(DataAccessException e) {
    super("There was a problem saving telemetry: ", e);
  }
}
