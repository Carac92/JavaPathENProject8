package tourGuide.model;


import java.util.UUID;

/**
 * TripPricerTask class is used to store the trip pricer task information
 */
public class TripPricerTask {
    private final UUID attractionId;
    private final String apiKey;
    private final int adults;
    private final int children;
    private final int nightsStay;

    public TripPricerTask(String apiKey, UUID attractionId, int adults, int children, int nightsStay) {
        this.apiKey = apiKey;
        this.attractionId = attractionId;
        this.adults = adults;
        this.children = children;
        this.nightsStay = nightsStay;
    }

    public UUID getAttractionId() {
        return attractionId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public int getNightsStay() {
        return nightsStay;
    }
}
