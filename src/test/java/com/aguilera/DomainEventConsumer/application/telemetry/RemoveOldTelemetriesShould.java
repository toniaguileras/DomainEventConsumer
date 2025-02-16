package com.aguilera.DomainEventConsumer.application.telemetry;

import com.aguilera.DomainEventConsumer.domain.CreationTime;
import com.aguilera.DomainEventConsumer.domain.DeviceId;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import com.aguilera.DomainEventConsumer.domain.exceptions.RemoveOldTelemetriesException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RemoveOldTelemetriesShould {
  @Test
  void remove_old_telemetries() {
    Integer deviceId = 1;
    OffsetDateTime creationDate = OffsetDateTime.now();

    TelemetryRepository telemetryRepository = mock(TelemetryRepository.class);
    RemoveOldTelemetries removeOldTelemetries = new RemoveOldTelemetries(telemetryRepository);
    RemoveOldTelemetriesCommand command = new RemoveOldTelemetriesCommand(deviceId, creationDate.toString());
    removeOldTelemetries.execute(command);

    ArgumentCaptor<DeviceId> argumentCaptor = ArgumentCaptor.forClass(DeviceId.class);
    ArgumentCaptor<CreationTime> argumentCaptor2 = ArgumentCaptor.forClass(CreationTime.class);
    verify(telemetryRepository).removeOlderThan(argumentCaptor.capture(), argumentCaptor2.capture());
    DeviceId firstValue = argumentCaptor.getValue();
    CreationTime secondValue = argumentCaptor2.getValue();
    assertEquals(firstValue.getValue(), deviceId);
    assertEquals(secondValue.getValue(), creationDate);
  }

  @Test
  void throw_exception_when_connection_with_database_fail() {
    Integer deviceId = 1;
    OffsetDateTime creationDate = OffsetDateTime.now();

    TelemetryRepository telemetryRepository = mock(TelemetryRepository.class);
    doThrow(RemoveOldTelemetriesException.class).when(telemetryRepository).removeOlderThan(any(DeviceId.class), any(CreationTime.class));
    RemoveOldTelemetries removeOldTelemetries = new RemoveOldTelemetries(telemetryRepository);
    RemoveOldTelemetriesCommand command = new RemoveOldTelemetriesCommand(deviceId, creationDate.toString());

    assertThrows(RemoveOldTelemetriesException.class, () -> removeOldTelemetries.execute(command));
  }
}