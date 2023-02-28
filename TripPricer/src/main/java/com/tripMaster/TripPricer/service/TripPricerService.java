package com.tripMaster.TripPricer.service;

import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Interface for TripPricer Service
 */
public interface TripPricerService {
    List<Provider> getPrice(String apiKey, UUID attractionId,
                            int adults, int children,
                            int nightsStay, int rewardsPoints);
}
