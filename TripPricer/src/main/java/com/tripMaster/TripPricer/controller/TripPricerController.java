package com.tripMaster.TripPricer.controller;

import com.tripMaster.TripPricer.service.TripPricerService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tripPricer.Provider;


import java.util.List;
import java.util.UUID;
/**
 * Controller class for TripPricer
 * Return a list of Provider for a trip with their price
 */
@RestController
public class TripPricerController {
    private final Logger log = org.slf4j.LoggerFactory.getLogger(TripPricerController.class);
    @Autowired
    private TripPricerService tripPricerService;

    @Operation(summary = "Get a list of provider for a given attraction, number of adults, children, nights stay and rewards points")
    @GetMapping("/getPrice/{apiKey}/{attractionId}/{adults}/{children}/{nightsStay}/{rewardsPoints}")
    public List<Provider> getPrice(@PathVariable String apiKey, @PathVariable UUID attractionId,
                                   @PathVariable int adults, @PathVariable int children,
                                   @PathVariable int nightsStay, @PathVariable int rewardsPoints) {
        log.info("Request to get price for attraction {} for {} adults, {} children, {} nights stay and {} rewards points"
                , attractionId, adults, children, nightsStay, rewardsPoints);
        return tripPricerService.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
    }

}
