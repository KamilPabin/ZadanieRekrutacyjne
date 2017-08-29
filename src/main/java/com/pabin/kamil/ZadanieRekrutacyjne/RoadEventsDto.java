package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.EventType;
import DataModels.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
class RoadEventsDto {


    private MyInterface myInterface;

    @Autowired
    RoadEventsDto(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    public List<EventOnRoad> findAll() {
        return myInterface.findAll();
    }

    public List<EventOnRoad> findByEventType(EventType eventType){
        return myInterface.findByEventType(eventType);
    }

    public List<EventOnRoad> findByEventType(List<EventType> eventTypes) {
        return myInterface.findByEventType(eventTypes);
    }
}
