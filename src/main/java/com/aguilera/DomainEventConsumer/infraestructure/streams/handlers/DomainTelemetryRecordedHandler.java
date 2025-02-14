package com.aguilera.DomainEventConsumer.infraestructure.streams.handlers;

import com.aguilera.DomainEventConsumer.application.RemoveOldTelemetries;
import com.aguilera.DomainEventConsumer.application.RemoveOldTelemetriesCommand;
import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedEvent;
import com.aguilera.DomainEventConsumer.domain.TelemetryRecordedHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class DomainTelemetryRecordedHandler implements TelemetryRecordedHandler {
  @Autowired
  private RemoveOldTelemetries removeOldTelemetries;

  public DomainTelemetryRecordedHandler(RemoveOldTelemetries removeOldTelemetries) {
    this.removeOldTelemetries = removeOldTelemetries;
  }

  @Override
  public void handle(TelemetryRecordedEvent event) {
    cleanOldTelemetries(event.getDeviceId(), event.getCreatedOn());
  }

  private void cleanOldTelemetries(Integer deviceId, String createdOn) {
    removeOldTelemetries.execute(new RemoveOldTelemetriesCommand(deviceId, createdOn));
  }
}
