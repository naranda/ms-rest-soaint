package com.soaint.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/actuator/health")
    public ResponseEntity<Void> health()  {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
