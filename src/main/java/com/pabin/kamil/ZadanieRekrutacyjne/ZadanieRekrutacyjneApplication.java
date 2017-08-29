package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.EventType;
import DataModels.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class ZadanieRekrutacyjneApplication implements CommandLineRunner{

    @Autowired
    private MyInterface myInterface;

    public static void main(String[] args) {
        SpringApplication.run(ZadanieRekrutacyjneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        myInterface.deleteAll();

        myInterface.save(new EventOnRoad(new LatLng(52.45, 18.22), "Ul. Konwaliowa",
                "Zderzenie dwóch autobusów", EventType.PUBLIC_TRANSPORT_FAILURE));
        myInterface.save(new EventOnRoad(new LatLng(52.0, 18.84), "Ul. Włocławska",
                "Przebudowa ronda", EventType.ROAD_REPAIRS));
    }
}
