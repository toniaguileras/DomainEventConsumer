package com.aguilera.DomainEventConsumer.application.telemetry;

import java.util.Objects;

public class RemoveOldTelemetriesCommand {
  private Integer deviceId;
  private String createdOn;

  public RemoveOldTelemetriesCommand(Integer deviceId, String createdOn) {
    this.deviceId = deviceId;
    this.createdOn = createdOn;
  }

  public Integer getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Integer deviceId) {
    this.deviceId = deviceId;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
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
    RemoveOldTelemetriesCommand that = (RemoveOldTelemetriesCommand) o;
    return Objects.equals(deviceId, that.deviceId) && Objects.equals(createdOn, that.createdOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceId, createdOn);
  }
}
