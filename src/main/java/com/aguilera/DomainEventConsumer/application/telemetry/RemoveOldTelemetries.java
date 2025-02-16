package com.aguilera.DomainEventConsumer.application.telemetry;

import com.aguilera.DomainEventConsumer.domain.CreationTime;
import com.aguilera.DomainEventConsumer.domain.DeviceId;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveOldTelemetries {
  private final TelemetryRepository telemetryRepository;

  public RemoveOldTelemetries(TelemetryRepository telemetryRepository) {
    this.telemetryRepository = telemetryRepository;
  }

  public void execute(RemoveOldTelemetriesCommand command){
    DeviceId deviceId = new DeviceId(command.getDeviceId());
    CreationTime creationTime = new CreationTime(command.getCreatedOn());

    telemetryRepository.removeOlderThan(deviceId, creationTime);
  }
}
