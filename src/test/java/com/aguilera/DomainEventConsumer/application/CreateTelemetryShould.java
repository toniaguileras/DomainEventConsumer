package com.aguilera.DomainEventConsumer.application;

import com.aguilera.DomainEventConsumer.application.telemetry.CreateTelemetry;
import com.aguilera.DomainEventConsumer.application.telemetry.TelemetryCommand;
import com.aguilera.DomainEventConsumer.domain.Telemetry;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import com.aguilera.DomainEventConsumer.domain.exceptions.SaveTelemetryException;
import com.aguilera.DomainEventConsumer.domain.shared.DomainEventPublisher;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateTelemetryShould {

  @Test
  void create_a_new_telemetry() {
    Integer deviceId = 1;
    Integer measurement = 12;
    OffsetDateTime creationDate = OffsetDateTime.now();

    DomainEventPublisher domainEventPublisher = mock(DomainEventPublisher.class);
    TelemetryRepository telemetryRepository = mock(TelemetryRepository.class);

    TelemetryCommand command = new TelemetryCommand(deviceId, measurement, creationDate.toString());
    CreateTelemetry createTelemetry = new CreateTelemetry(telemetryRepository, domainEventPublisher);

    createTelemetry.execute(command);

    ArgumentCaptor<Telemetry> argumentCaptor = ArgumentCaptor.forClass(Telemetry.class);
    verify(telemetryRepository).save(argumentCaptor.capture());
    Telemetry firstValue = argumentCaptor.getValue();
    assertEquals(firstValue.getDeviceId().getValue(), deviceId);
    assertEquals(firstValue.getMeasurement(), measurement);
    assertEquals(firstValue.getCreationTime().getValue(), creationDate);
  }

  @Test
  void throw_exception_when_connection_with_database_fail() {
    Integer deviceId = 1;
    Integer measurement = 12;
    OffsetDateTime creationDate = OffsetDateTime.now();

    DomainEventPublisher domainEventPublisher = mock(DomainEventPublisher.class);
    TelemetryRepository telemetryRepository = mock(TelemetryRepository.class);
    doThrow(SaveTelemetryException.class).when(telemetryRepository).save(any(Telemetry.class));

    TelemetryCommand command = new TelemetryCommand(deviceId, measurement, creationDate.toString());
    CreateTelemetry createTelemetry = new CreateTelemetry(telemetryRepository, domainEventPublisher);

    assertThrows(SaveTelemetryException.class, () -> createTelemetry.execute(command));
  }
}