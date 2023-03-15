package tourGuide.model;

/**
 * Location class is used to store the location information
 */
public class Location {
    public final double longitude;
    public final double latitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
