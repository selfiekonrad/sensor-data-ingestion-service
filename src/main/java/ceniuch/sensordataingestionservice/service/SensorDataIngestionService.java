package ceniuch.sensordataingestionservice.service;

import ceniuch.sensordataingestionservice.model.SensorDataEvent;
import ceniuch.sensordataingestionservice.model.dtos.SensorDataRequestDto;
import ceniuch.sensordataingestionservice.model.dtos.SensorDataResponseDto;
import ceniuch.sensordataingestionservice.model.mappers.SensorDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class SensorDataIngestionService {
    private final SensorDataMapper sensorDataMapper;

    //@Autowired
    public SensorDataIngestionService(SensorDataMapper sensorDataMapper) {
        this.sensorDataMapper = sensorDataMapper;
    }

    public SensorDataResponseDto ingest(SensorDataRequestDto requestDto) {
        SensorDataEvent sensorDataEvent = sensorDataMapper.toEvent(requestDto);
        sensorDataEvent.setEventId(UUID.randomUUID());
        sensorDataEvent.setEnqueuedAt(Instant.now());

        // insert in queue


        return new SensorDataResponseDto(
                "",
                sensorDataEvent.getEventId().toString(),
                "Data queued for processing",
                Instant.now()
        );
    }

    // TODO: BatchIngest
}
