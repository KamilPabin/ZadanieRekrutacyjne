package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/")
class RoadEventsEndpoint {

    private NearbyPlaceFacade nearbyPlaceFacade;

    @Autowired
    public RoadEventsEndpoint(NearbyPlaceFacade nearbyPlaceFacade) {
        this.nearbyPlaceFacade = nearbyPlaceFacade;
    }

    @PostMapping("places")
    public ResponseEntity<List<EventOnRoad>> sendData() {

        return new ResponseEntity(nearbyPlaceFacade.findAll() , HttpStatus.OK);
    }
}
