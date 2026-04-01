package ceniuch.sensordataingestionservice.controller;

import ceniuch.sensordataingestionservice.model.dtos.SensorDataRequestDto;
import ceniuch.sensordataingestionservice.model.dtos.SensorDataResponseDto;
import ceniuch.sensordataingestionservice.service.SensorDataIngestionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/sensor-data")
@Slf4j
public class SensorDataIngestionController {

    private final SensorDataIngestionService sensorDataIngestionService;

    @Autowired
    public SensorDataIngestionController(SensorDataIngestionService sensorDataIngestionService) {
        this.sensorDataIngestionService = sensorDataIngestionService;
    }


    @PostMapping()
    ResponseEntity<SensorDataResponseDto> ingestionSensorData(
            @Valid @RequestBody SensorDataRequestDto requestDto
            ) {

        log.info("Received sensor data from sensor: {}", requestDto.machineId());
        SensorDataResponseDto response = sensorDataIngestionService.ingest(requestDto);
        return ResponseEntity.accepted().body(response);
    }
}
