package com.aguilera.DomainEventConsumer.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Embeddable
public class CreationTime implements Serializable {
  private static final long serialVersionUID = 1L;

  private OffsetDateTime value;

  public CreationTime(String value) {
    this.value = OffsetDateTime.parse(value);
  }

  public OffsetDateTime getValue() {
    return value;
  }

  public void setValue(OffsetDateTime value) {
    this.value = value;
  }
}
