package ceniuch.sensordataingestionservice.model.mappers;

import ceniuch.sensordataingestionservice.model.SensorDataEvent;
import ceniuch.sensordataingestionservice.model.dtos.SensorDataRequestDto;
import org.springframework.stereotype.Component;

@Component
public class SensorDataMapper {
    public SensorDataEvent toEvent(SensorDataRequestDto dto) {
        SensorDataEvent sensorDataEvent = new SensorDataEvent();
        sensorDataEvent.setMachineId(dto.machineId());
        sensorDataEvent.setSensorId(dto.sensorId());
        sensorDataEvent.setValue(dto.value());
        sensorDataEvent.setUnit(dto.unit());
        sensorDataEvent.setTimestamp(dto.timestamp());
        return sensorDataEvent;
    }
}
