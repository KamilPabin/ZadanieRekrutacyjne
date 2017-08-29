package DataModels;

/**
 * Created by Little on 2017-08-24.
 */
public class LatLng {

    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LatLng() {
    }

    public LatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double distanceTo(LatLng point){

        return 0.0;
    }
}
