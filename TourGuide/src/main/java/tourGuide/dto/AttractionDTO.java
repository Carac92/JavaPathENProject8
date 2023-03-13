package tourGuide.dto;

import tourGuide.model.Attraction;
import tourGuide.model.VisitedLocation;

public class AttractionDTO extends Attraction {
    private VisitedLocation userLocation;
    private double distance;
    private int rewardPoints;
    public AttractionDTO(String attractionName, String city, String state, double latitude, double longitude, VisitedLocation userLocation, double distance, int rewardPoints) {
        super(attractionName, city, state, latitude, longitude);
        this.userLocation = userLocation;
        this.distance = distance;
        this.rewardPoints = rewardPoints;
    }

    public VisitedLocation getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(VisitedLocation userLocation) {
        this.userLocation = userLocation;
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
}
