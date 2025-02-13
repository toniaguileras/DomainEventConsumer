package com.aguilera.DomainEventConsumer.domain;

import jakarta.persistence.Embedded;

public class Telemetry {
  @Embedded
  private DeviceId deviceId;
  private Integer measurement;
  @Embedded
  private CreationTime creationTime;

  public Telemetry(DeviceId deviceId, Integer measurement, CreationTime creationTime) {
    this.deviceId = deviceId;
    this.measurement = measurement;
    this.creationTime = creationTime;
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
}
