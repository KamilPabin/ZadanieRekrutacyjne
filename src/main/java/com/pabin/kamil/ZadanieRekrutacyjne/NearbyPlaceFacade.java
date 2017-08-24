package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.LatLngR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Little on 2017-08-24.
 */

@Component
public class NearbyPlaceFacade {

    private InMemoryRepository inMemoryRepository;

    @Autowired
    public NearbyPlaceFacade(InMemoryRepository inMemoryRepository) {
        this.inMemoryRepository = inMemoryRepository;
    }

    public List<EventOnRoad> findClosest(LatLngR currentPosition) {
        return inMemoryRepository.findClosests(currentPosition);
    }

}
