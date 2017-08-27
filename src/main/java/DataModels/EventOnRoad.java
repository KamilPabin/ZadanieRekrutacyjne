package DataModels;

/**
 * Created by Little on 2017-08-24.
 */
public class EventOnRoad {

    private static long IDhelper = 0;
    private long ID;

    private double latitude;
    private double longitude;


    private String name;
    private String description;

    private String type;

    public EventOnRoad(double latitude, double longitude, String name, String description, String type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.description = description;
        this.type = type;
        ID = IDhelper++;
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


    public long getID() {
        return ID;
    }
}
