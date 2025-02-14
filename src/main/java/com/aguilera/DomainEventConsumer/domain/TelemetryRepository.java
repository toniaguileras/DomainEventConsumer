package com.aguilera.DomainEventConsumer.domain;

public interface TelemetryRepository {
  void save(Telemetry telemetry);

  void removeOlderThan(DeviceId deviceId, CreationTime creationTime);
}
