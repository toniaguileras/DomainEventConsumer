package com.aguilera.DomainEventConsumer.application.telemetry;

import java.time.OffsetDateTime;
import java.util.Objects;

public class TelemetryDto {

  private Integer deviceId;
  private Integer measurement;
  private OffsetDateTime createdOn;

  public TelemetryDto(Integer deviceId, Integer measurement, OffsetDateTime createdOn) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelemetryDto that = (TelemetryDto) o;
    return Objects.equals(deviceId, that.deviceId)
      && Objects.equals(measurement, that.measurement)
      && Objects.equals(createdOn, that.createdOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceId, measurement, createdOn);
  }
}
