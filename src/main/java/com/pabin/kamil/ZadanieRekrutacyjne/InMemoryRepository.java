package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.LatLngR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InMemoryRepository {

    private List<EventOnRoad> Places = new ArrayList<>();

    @Autowired
    public InMemoryRepository(){
        Places.add(new EventOnRoad(10.0, 11.0,"Place 1", "desc1", "bus"));
        Places.add(new EventOnRoad(11.0,15.0,"Place 2", "desc 2", "remont"));
    }

    public List<EventOnRoad> findClosests(LatLngR data){
        return Places.stream().filter( p  -> isInRange(p,data)).collect(Collectors.toList());
    }

    private boolean isInRange(EventOnRoad place , LatLngR myPosition) {
        //TODO: Wykonać obliczenia dla odległości punktów
        return true;
    }
}
