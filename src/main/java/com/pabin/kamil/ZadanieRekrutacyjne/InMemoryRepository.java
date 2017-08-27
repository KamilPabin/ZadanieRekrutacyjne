package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.LatLngR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
class InMemoryRepository {

    private List<EventOnRoad> Places = new ArrayList<>();

    @Autowired
    public InMemoryRepository() {
        Places.add(new EventOnRoad(52.45, 18.22, "Ul. Konwaliowa", "Zderzenie dwóch autobusów", "bus"));
        Places.add(new EventOnRoad(52.0, 18.84, "Ul. Włocławska", "Przebudowa ronda", "remont"));
    }

    public List<EventOnRoad> findClosests(LatLngR data) {
        return Places.stream().filter(p -> isInRange(p, data)).collect(Collectors.toList());
    }

    private boolean isInRange(EventOnRoad place, LatLngR myPosition) {
        //TODO: Wykonać obliczenia dla odległości punktów
        return true;
    }
}
