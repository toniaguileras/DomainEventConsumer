package com.aguilera.DomainEventConsumer.application.telemetry;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelemetryCommand that = (TelemetryCommand) o;
    return Objects.equals(id, that.id)
      && Objects.equals(measurement, that.measurement)
      && Objects.equals(date, that.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, measurement, date);
  }
}
