package com.aguilera.DomainEventConsumer.domain;

import com.aguilera.DomainEventConsumer.domain.shared.DomainEvent;

import java.time.OffsetDateTime;

public class TelemetryRecordedEvent extends DomainEvent {
  private Integer deviceId;
  private Integer measurement;
  private String createdOn;

  public TelemetryRecordedEvent(Integer deviceId, Integer measurement, String createdOn) {
    super(deviceId.toString());
    this.deviceId = deviceId;
    this.measurement = measurement;
    this.createdOn = createdOn;
  }

  public Integer getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Integer deviceId) {
    this.deviceId = deviceId;
  }

  public Integer getMeasurement() {
    return measurement;
  }

  public void setMeasurement(Integer measurement) {
    this.measurement = measurement;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }
}
