package com.aguilera.DomainEventConsumer.infraestructure.controller;

import com.aguilera.DomainEventConsumer.application.CreateTelemetry;
import com.aguilera.DomainEventConsumer.application.TelemetryCommand;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostTelemetryController {

  @Autowired
  private CreateTelemetry createTelemetry;

  public PostTelemetryController(CreateTelemetry createTelemetry) {this.createTelemetry = createTelemetry;}

  @PostMapping("/telemetry")
  public ResponseEntity<Any> post(
    @RequestBody TelemetryRequest telemetryRequest
  ) {
    createTelemetry.execute(new TelemetryCommand(
      telemetryRequest.getDeviceId(),
      telemetryRequest.getMeasurement(),
      telemetryRequest.getDate()
    ));
    return ResponseEntity.ok().build();
  }
}
