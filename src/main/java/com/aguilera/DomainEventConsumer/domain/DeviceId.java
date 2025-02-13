package com.aguilera.DomainEventConsumer.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class DeviceId implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer value;

  public DeviceId(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }
}
