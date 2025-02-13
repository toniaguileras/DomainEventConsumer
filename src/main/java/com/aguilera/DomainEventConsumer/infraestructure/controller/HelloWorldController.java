package com.aguilera.DomainEventConsumer.infraestructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  @GetMapping
  public ResponseEntity<String> get() {
    return ResponseEntity.ok("it works!");
  }
}
