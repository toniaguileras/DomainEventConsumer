package com.aguilera.DomainEventConsumer.infraestructure.controller.telemetry;

import com.aguilera.DomainEventConsumer.application.FindTelemetry;
import com.aguilera.DomainEventConsumer.application.TelemetryDto;
import com.aguilera.DomainEventConsumer.domain.exceptions.FindTelemetryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetTelemetryController {
  private static final Logger logger = LoggerFactory.getLogger(GetTelemetryController.class);


  @Autowired
  private FindTelemetry findTelemetry;

  @GetMapping("/telemetry")
  public ResponseEntity<List<TelemetryResponse>> get() {
    List<TelemetryDto> telemetries = findTelemetry.execute();
   try {
     return ResponseEntity.ok(telemetries.stream()
       .map(it -> new TelemetryResponse(it.getDeviceId(), it.getMeasurement(),
         it.getCreatedOn()
       ))
       .toList());
   }catch (FindTelemetryException e){
     logger.error("There was a problem returning telemetries.", e.getCause());
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
   }
  }
}
