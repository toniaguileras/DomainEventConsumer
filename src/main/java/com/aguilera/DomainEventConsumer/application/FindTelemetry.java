package com.aguilera.DomainEventConsumer.application;

import com.aguilera.DomainEventConsumer.domain.Telemetry;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FindTelemetry {
  @Autowired
  private TelemetryRepository telemetryRepository;

  public FindTelemetry(TelemetryRepository telemetryRepository) {
    this.telemetryRepository = telemetryRepository;
  }

  public List<TelemetryDto> execute() {
    List<Telemetry> telemetryList = telemetryRepository.findAll();
    return telemetryList.stream()
      .map(it -> new TelemetryDto(it.getDeviceId().getValue(), it.getMeasurement(), it.getCreationTime().getValue()))
      .toList();
  }
}
