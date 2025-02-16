package com.aguilera.DomainEventConsumer.domain;

import jakarta.persistence.Embedded;

import java.util.Objects;

public class Telemetry extends DomainEntity {
  @Embedded
  private DeviceId deviceId;
  private Integer measurement;
  @Embedded
  private CreationTime creationTime;

  public Telemetry(DeviceId deviceId, Integer measurement, CreationTime creationTime) {
    this.deviceId = deviceId;
    this.measurement = measurement;
    this.creationTime = creationTime;
    addDomainEvent(new TelemetryRecordedEvent(
      deviceId.getValue(),
      measurement,
      creationTime.getValue().toString()
    ));
  }

  public DeviceId getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(DeviceId deviceId) {
    this.deviceId = deviceId;
  }

  public Integer getMeasurement() {
    return measurement;
  }

  public void setMeasurement(Integer measurement) {
    this.measurement = measurement;
  }

  public CreationTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(CreationTime creationTime) {
    this.creationTime = creationTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Telemetry telemetry = (Telemetry) o;
    return Objects.equals(deviceId, telemetry.deviceId) && Objects.equals(
      measurement,
      telemetry.measurement
    ) && Objects.equals(creationTime, telemetry.creationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceId, measurement, creationTime);
  }
}
