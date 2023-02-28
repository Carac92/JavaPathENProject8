package tourGuide.model;

import java.util.UUID;

public class TripPricerTask {
        private UUID attractionId;
        private String apiKey;
        private int adults;
        private int children;
        private int nightsStay;

        public TripPricerTask(String apiKey, UUID attractionId, int adults, int children, int nightsStay) {
            this.apiKey = apiKey;
            this.attractionId = attractionId;
            this.adults = adults;
            this.children = children;
            this.nightsStay = nightsStay;
        }
}
