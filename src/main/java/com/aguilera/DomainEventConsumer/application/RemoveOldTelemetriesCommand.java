package com.aguilera.DomainEventConsumer.application;

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
}
