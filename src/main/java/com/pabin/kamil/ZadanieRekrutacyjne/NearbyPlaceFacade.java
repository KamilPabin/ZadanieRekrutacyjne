package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.LatLngR;

import java.util.List;

/**
 * Created by Little on 2017-08-24.
 */
public class NearbyPlaceFacade {

    private InMemoryRepository inMemoryRepository;


    public List<EventOnRoad> findClosest(LatLngR currentPosition) {
        return inMemoryRepository.findClosests(currentPosition);
    }

}
