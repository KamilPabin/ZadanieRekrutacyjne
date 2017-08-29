package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.EventType;
import DataModels.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
class InMemoryRepository {

    private List<EventOnRoad> Places = new ArrayList<>();

    public InMemoryRepository() {
        Places.add(new EventOnRoad(new LatLng(52.45, 18.22), "Ul. Konwaliowa",
                "Zderzenie dwóch autobusów", EventType.PUBLIC_TRANSPORT_FAILURE));
        Places.add(new EventOnRoad(new LatLng(52.0, 18.84), "Ul. Włocławska",
                "Przebudowa ronda", EventType.ROAD_REPAIRS));
    }

    public List<EventOnRoad> findClosests(LatLng data) {
        return Places.stream().filter(p -> data.distanceTo(p.position) < 10).collect(Collectors.toList());
    }

}
