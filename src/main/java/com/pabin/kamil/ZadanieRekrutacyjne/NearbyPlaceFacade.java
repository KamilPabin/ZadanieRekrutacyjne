package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.EventType;
import DataModels.FilterParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NearbyPlaceFacade {


    private InMemoryRepository inMemoryRepository;
    private RoadEventsDto roadEventsDto;

    @Autowired
    public NearbyPlaceFacade(InMemoryRepository inMemoryRepository, RoadEventsDto roadEventsDto) {
        this.inMemoryRepository = inMemoryRepository;
        this.roadEventsDto = roadEventsDto;
    }

    public List<EventOnRoad> findAll() {
        return roadEventsDto.findAll();
    }

    public List<EventOnRoad> findByEventType(EventType eventType) {
        return roadEventsDto.findByEventType(eventType);
    }

    public List<EventOnRoad> filter(FilterParameters parameters) {
        return roadEventsDto.filter(parameters);
    }
}
