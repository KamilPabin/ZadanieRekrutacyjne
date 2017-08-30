package DataModels;

import DataModels.EventType;
import DataModels.LatLng;

import java.util.List;

public class FilterParameters {

    private LatLng position;
    private List<EventType> eventTypeList;
    private double radius;

    public FilterParameters() {
    }

    public FilterParameters(LatLng position, List<EventType> eventTypeList, double radius) {
        this.position = position;
        this.eventTypeList = eventTypeList;
        this.radius = radius;
    }

    public LatLng getPosition() {
        return position;
    }

    public List<EventType> getEventTypeList() {
        return eventTypeList;
    }

    public double getRadius() {
        return radius;
    }
}