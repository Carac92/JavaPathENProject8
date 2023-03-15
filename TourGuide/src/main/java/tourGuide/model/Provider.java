package tourGuide.model;

import java.util.UUID;

/**
 * Provider class is used to store the provider information
 */
public class Provider {
    public final String name;
    public final double price;
    public final UUID tripId;

    public Provider(UUID tripId, String name, double price) {
        this.name = name;
        this.tripId = tripId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public UUID getTripId() {
        return tripId;
    }
}
