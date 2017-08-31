package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.EventType;
import DataModels.FilterParameters;
import DataModels.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        List<EventOnRoad> result = new ArrayList();
        for (EventType event : eventTypes) {
            result.addAll(findByEventType(event));
        }
        return result;
    }

    public List<EventOnRoad> findClosest(LatLng position, double radius) {
        return myInterface.findAll().stream().filter(p ->
            position.distanceTo(p.position) < radius
        ).collect(Collectors.toList());
    }

    public List<EventOnRoad> findClosest(LatLng position, double radius, List<EventOnRoad> list) {

        return list.stream().filter(p ->
            position.distanceTo(p.position) < radius
        ).collect(Collectors.toList());

    }

    public List<EventOnRoad> filter(FilterParameters parameters) {

        List<EventOnRoad> result;

        if(parameters.getEventTypeList().isEmpty()) {
            return new ArrayList();
        } else {
            result = findByEventType(parameters.getEventTypeList());
        }

        if(parameters.getRadius() == 0) {
            return result;
        }

        return findClosest(parameters.getPosition(),parameters.getRadius(),result);

    }

}
