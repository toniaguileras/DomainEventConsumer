package com.aguilera.DomainEventConsumer.infraestructure.controller.telemetry;

import java.time.OffsetDateTime;

public class TelemetryResponse {
  private Integer deviceId;
  private Integer measurement;
  private OffsetDateTime createdOn;

  public TelemetryResponse(Integer deviceId, Integer measurement, OffsetDateTime createdOn) {
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

  public OffsetDateTime getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(OffsetDateTime createdOn) {
    this.createdOn = createdOn;
  }
}
