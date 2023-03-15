package tourGuide.model;


import java.util.Date;
import java.util.UUID;

/**
 * VisitedLocation class is used to store the visited location information
 */
public class VisitedLocation {
        public final UUID userId;
        public final Location location;
        public final Date timeVisited;

        public VisitedLocation(UUID userId, Location location, Date timeVisited) {
            this.userId = userId;
            this.location = location;
            this.timeVisited = timeVisited;
        }

    public UUID getUserId() {
        return userId;
    }

    public Location getLocation() {
        return location;
    }

    public Date getTimeVisited() {
        return timeVisited;
    }
}
