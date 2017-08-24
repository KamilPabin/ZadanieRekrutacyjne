package DataModels;

/**
 * Created by Little on 2017-08-24.
 */
public class EventOnRoad {

    private double longitude;
    private double latitude;

    private String name;
    private String description;

    private String type;

    public EventOnRoad(double longitude, double latitude, String name, String description, String type) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
