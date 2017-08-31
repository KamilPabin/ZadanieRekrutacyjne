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

    public double distanceTo(LatLng point) {
        double R = 6371;
        double dLat = Math.toRadians(latitude - point.latitude);
        double dLon = Math.toRadians(longitude - point.longitude);
        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(point.latitude)) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c * 1000;
        System.out.println(d);
        return d;
    }
}
