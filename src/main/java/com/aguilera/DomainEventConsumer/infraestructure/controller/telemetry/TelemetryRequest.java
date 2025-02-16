package com.aguilera.DomainEventConsumer.infraestructure.controller.telemetry;

public class TelemetryRequest {
  private Integer deviceId;
  private Integer telemetry;
  private String date;

  public TelemetryRequest(Integer deviceId, Integer telemetry, String date) {
    this.deviceId = deviceId;
    this.telemetry = telemetry;
    this.date = date;
  }

  public Integer getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Integer deviceId) {
    this.deviceId = deviceId;
  }

  public Integer getTelemetry() {
    return telemetry;
  }

  public void setTelemetry(Integer telemetry) {
    this.telemetry = telemetry;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
