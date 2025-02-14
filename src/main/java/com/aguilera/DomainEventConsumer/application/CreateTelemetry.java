package com.aguilera.DomainEventConsumer.application;

import com.aguilera.DomainEventConsumer.domain.CreationTime;
import com.aguilera.DomainEventConsumer.domain.DeviceId;
import com.aguilera.DomainEventConsumer.domain.Telemetry;
import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedEvent;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import com.aguilera.DomainEventConsumer.domain.shared.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTelemetry {

  @Autowired
  private TelemetryRepository telemetryRepository;

  @Autowired
  private final DomainEventPublisher domainEventPublisher;

  public CreateTelemetry(TelemetryRepository telemetryRepository, DomainEventPublisher domainEventPublisher) {
    this.telemetryRepository = telemetryRepository;
    this.domainEventPublisher = domainEventPublisher;
  }

  public void execute(TelemetryCommand command) {
    CreationTime creationTime = new CreationTime(command.getDate());
    DeviceId deviceId = new DeviceId(command.getId());
    Telemetry telemetry = new Telemetry(deviceId, command.getMeasurement(), creationTime);
    telemetryRepository.save(telemetry);
    domainEventPublisher.publish(telemetry.getDomainEvents());
  }
}
