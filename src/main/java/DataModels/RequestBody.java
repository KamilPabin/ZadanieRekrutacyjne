package DataModels;

import java.util.List;

/**
 * Created by Little on 2017-08-29.
 */
public class RequestBody {

    private LatLng position;
    private List<EventType> eventTypeList;
    private double radius;

    public RequestBody() {
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
