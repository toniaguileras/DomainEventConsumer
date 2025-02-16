package com.aguilera.DomainEventConsumer.infraestructure.controller.telemetry;

import com.aguilera.DomainEventConsumer.application.CreateTelemetry;
import com.aguilera.DomainEventConsumer.application.TelemetryCommand;
import com.aguilera.DomainEventConsumer.domain.exceptions.AlreadyExistsTelemetryException;
import com.aguilera.DomainEventConsumer.domain.exceptions.SaveTelemetryException;
import org.hibernate.mapping.Any;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostTelemetryController {
  private static final Logger logger = LoggerFactory.getLogger(PostTelemetryController.class);

  @Autowired
  private final CreateTelemetry createTelemetry;

  public PostTelemetryController(CreateTelemetry createTelemetry) {this.createTelemetry = createTelemetry;}

  @PostMapping("/telemetry")
  public ResponseEntity<Any> post(
    @RequestBody TelemetryRequest telemetryRequest
  ) {
    try {
      createTelemetry.execute(new TelemetryCommand(
        telemetryRequest.getDeviceId(),
        telemetryRequest.getTelemetry(),
        telemetryRequest.getDate()
      ));
      return ResponseEntity.ok().build();
    } catch (AlreadyExistsTelemetryException e) {
      logger.error("This telemetry already exists.", e.getCause());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } catch (SaveTelemetryException e) {
      logger.error("There was a problem saving telemetry", e.getCause());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } catch (Exception e) {
      logger.error("Unexpected error", e.getCause());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
