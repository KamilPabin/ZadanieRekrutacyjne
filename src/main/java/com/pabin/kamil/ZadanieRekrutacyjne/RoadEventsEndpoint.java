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

    @PostMapping("places")
    public ResponseEntity<List<EventOnRoad>> sendData(@RequestParam(value = "lat") double lat,
                                                      @RequestParam(value = "lng") double lng,
                                                      @RequestParam(value = "r") double radius) {

        return new ResponseEntity(nearbyPlaceFacade.findClosest(new LatLngR(lat,lng,radius)) , HttpStatus.OK);
    }
}
