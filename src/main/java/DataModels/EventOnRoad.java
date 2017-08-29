package DataModels;

import org.springframework.data.annotation.Id;

public class EventOnRoad {

    @Id
    public String ID;

    public LatLng position;

    public String roadName;
    public String eventDescription;

    public EventType eventType;

    public EventOnRoad(LatLng position, String roadName, String eventDescription, EventType eventType) {
        this.position = position;
        this.roadName = roadName;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
    }
}
