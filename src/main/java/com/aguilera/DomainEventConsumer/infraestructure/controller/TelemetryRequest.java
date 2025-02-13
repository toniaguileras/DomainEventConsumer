package com.aguilera.DomainEventConsumer.infraestructure.controller;

public class TelemetryRequest {
  private Integer deviceId;
  private Integer measurement;
  private String date;

  public TelemetryRequest(Integer deviceId, Integer measurement, String date) {
    this.deviceId = deviceId;
    this.measurement = measurement;
    this.date = date;
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

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
