package com.aguilera.DomainEventConsumer.application.telemetry;

import com.aguilera.DomainEventConsumer.domain.CreationTime;
import com.aguilera.DomainEventConsumer.domain.DeviceId;
import com.aguilera.DomainEventConsumer.domain.Telemetry;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.internal.matchers.Find;
import org.springframework.util.Assert;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FindTelemetryShould {

  @Test
  void return_a_list_of_telemetries() {
    DeviceId deviceId1 = new DeviceId(1);
    Integer measurement1 = 2;
    CreationTime createdOn1 = new CreationTime(OffsetDateTime.now());
    Telemetry telemetry1 = new Telemetry(deviceId1, measurement1, createdOn1);
    DeviceId deviceId2 = new DeviceId(2);
    Integer measurement2 = 5;
    CreationTime createdOn2 = new CreationTime(OffsetDateTime.now());
    Telemetry telemetry2 = new Telemetry(deviceId2, measurement2, createdOn2);
    DeviceId deviceId3 = new DeviceId(3);
    Integer measurement3 = 10;
    CreationTime createdOn3 = new CreationTime(OffsetDateTime.now());
    Telemetry telemetry3 = new Telemetry(deviceId3, measurement3, createdOn3);

    TelemetryRepository telemetryRepository = mock(TelemetryRepository.class);

    when(telemetryRepository.findAll()).thenReturn(Arrays.asList(telemetry1, telemetry2, telemetry3));
    FindTelemetry findTelemetry = new FindTelemetry(telemetryRepository);
    List<TelemetryDto> result = findTelemetry.execute();

    List<TelemetryDto> expectedList = Arrays.asList(
      new TelemetryDto(deviceId1.getValue(), measurement1, createdOn1.getValue()),
      new TelemetryDto(deviceId2.getValue(), measurement2, createdOn2.getValue()),
      new TelemetryDto(deviceId3.getValue(), measurement3, createdOn3.getValue())
    );

    Assertions.assertEquals(expectedList, result);
  }
}