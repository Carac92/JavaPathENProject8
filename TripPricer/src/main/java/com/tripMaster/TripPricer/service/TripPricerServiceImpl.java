package com.tripMaster.TripPricer.service;

import org.springframework.stereotype.Service;
import tripPricer.Provider;
import tripPricer.TripPricer;

import java.util.List;
import java.util.UUID;

/**
 * Service class for TripPricer
 * Return a list of Provider for a trip with their price
 */
@Service
public class TripPricerServiceImpl implements TripPricerService {

    private final TripPricer tripPricer = new TripPricer();
    @Override
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints) {
        return tripPricer.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
    }
}
