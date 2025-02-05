package tourGuide.model;


import java.util.UUID;

/**
 * Attraction class is used to store the attraction information
 */
public class Attraction extends Location {
    public final String attractionName;
    public final String city;
    public final String state;
    public final UUID attractionId;


    public Attraction(String attractionName, String city, String state, double latitude, double longitude) {
        super(longitude, latitude);
        this.attractionName = attractionName;
        this.city = city;
        this.state = state;
        this.attractionId = UUID.randomUUID();
    }

    public String getAttractionName() {
        return attractionName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public UUID getAttractionId() {
        return attractionId;
    }
}
