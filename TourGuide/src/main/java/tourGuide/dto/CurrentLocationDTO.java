package tourGuide.dto;

import tourGuide.model.Location;

import java.util.UUID;

public class CurrentLocationDTO extends Location {

    private UUID userId;

    public CurrentLocationDTO(UUID userId,double latitude, double longitude) {
        super(latitude, longitude);
        this.userId = userId;
    }
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{" + userId + ": {" +
                "longitude:" + longitude +
                ", latitude :" + latitude + "}" +
                '}';
    }
}
