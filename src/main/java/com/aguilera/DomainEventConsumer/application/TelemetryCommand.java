package com.aguilera.DomainEventConsumer.application;

public class TelemetryCommand {
  private Integer id;
  private Integer measurement;
  private String date;

  public TelemetryCommand(Integer id, Integer measurement, String date) {
    this.id = id;
    this.measurement = measurement;
    this.date = date;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
