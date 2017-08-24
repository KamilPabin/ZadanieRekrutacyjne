package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.LatLngR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RoadEventsEndpoint {

    private NearbyPlaceFacade nearbyPlaceFacade;

    @Autowired
    public RoadEventsEndpoint(NearbyPlaceFacade nearbyPlaceFacade) {
        this.nearbyPlaceFacade = nearbyPlaceFacade;
    }

    @GetMapping("places")
    public ResponseEntity<List<EventOnRoad>> sendData(@RequestBody LatLngR latLngR) {

        return new ResponseEntity(nearbyPlaceFacade.findClosest(latLngR) , HttpStatus.OK);
    }
}
