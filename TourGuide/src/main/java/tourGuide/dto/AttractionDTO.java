package tourGuide.dto;

import tourGuide.model.Attraction;
import tourGuide.model.Location;
import tourGuide.model.VisitedLocation;

public class AttractionDTO extends Location {

    private String attractionName;
    private double userLatitude;
    private double userLongitude;
    private double distance;
    private int rewardPoints;
    public AttractionDTO(double latitude, double longitude, String attractionName, VisitedLocation userLocation, double distance, int rewardPoints) {
        super(latitude, longitude);
        this.attractionName = attractionName;
        this.userLatitude = userLocation.getLocation().latitude;
        this.userLongitude = userLocation.getLocation().longitude;
        this.distance = distance;
        this.rewardPoints = rewardPoints;
    }
    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public double getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(double userLatitude) {
        this.userLatitude = userLatitude;
    }

    public double getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(double userLongitude) {
        this.userLongitude = userLongitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String toString() {
        return "AttractionDTO{" +
                "attractionName='" + attractionName + '\'' +
                ", userLatitude=" + userLatitude +
                ", userLongitude=" + userLongitude +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", distance=" + distance +
                ", rewardPoints=" + rewardPoints +
                '}';
    }
}
