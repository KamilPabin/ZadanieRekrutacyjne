package DataModels;

/**
 * Created by Little on 2017-08-24.
 */
public class LatLngR {

    private double latitude;
    private double longitude;
    private double radius;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }

    public LatLngR(double latitude, double longitude, double radius) {

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }
}
