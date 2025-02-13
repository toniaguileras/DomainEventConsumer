package com.aguilera.DomainEventConsumer.application;

import com.aguilera.DomainEventConsumer.domain.CreationTime;
import com.aguilera.DomainEventConsumer.domain.DeviceId;
import com.aguilera.DomainEventConsumer.domain.Telemetry;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTelemetry {

  private TelemetryRepository telemetryRepository;

  public CreateTelemetry(TelemetryRepository telemetryRepository) {
    this.telemetryRepository = telemetryRepository;
  }

  public void execute(TelemetryCommand command) {
    CreationTime creationTime = new CreationTime(command.getDate());
    DeviceId deviceId = new DeviceId(command.getId());
    Telemetry telemetry = new Telemetry(deviceId, command.getMeasurement(), creationTime);
    telemetryRepository.save(telemetry);
  }
}
