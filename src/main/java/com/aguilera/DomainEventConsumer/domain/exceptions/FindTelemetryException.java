package com.aguilera.DomainEventConsumer.domain.exceptions;

import org.springframework.dao.DataAccessException;

public class FindTelemetryException extends RuntimeException {
  public FindTelemetryException(DataAccessException e) {
    super("There was a problem finding telemetries: ", e);
  }
}
