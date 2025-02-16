package com.aguilera.DomainEventConsumer.domain;

import java.util.List;

public interface TelemetryRepository {
  List<Telemetry> findAll();

  void save(Telemetry telemetry);

  void removeOlderThan(DeviceId deviceId, CreationTime creationTime);
}
