package com.pabin.kamil.ZadanieRekrutacyjne;

import DataModels.EventOnRoad;
import DataModels.EventType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
interface MyInterface extends MongoRepository<EventOnRoad, String> {

    List<EventOnRoad> findByEventType(EventType type);
    List<EventOnRoad> findByEventType(List<EventType> eventTypes);

}
