package com.aguilera.DomainEventConsumer.domain.exceptions;

import org.springframework.dao.DataAccessException;

public class RemoveOldTelemetriesException extends RuntimeException {
  public RemoveOldTelemetriesException(DataAccessException e) {
    super("There was a problem removing old telemetries: ", e);
  }
}
