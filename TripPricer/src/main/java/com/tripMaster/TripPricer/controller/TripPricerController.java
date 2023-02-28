package com.tripMaster.TripPricer.controller;

import com.tripMaster.TripPricer.service.TripPricerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TripPricerController {
    @Autowired
    private TripPricerService tripPricerService;

    @GetMapping("/getPrice/{apiKey}/{attractionId}/{adults}/{children}/{nightsStay}/{rewardsPoints}")
    public String getPrice(@PathVariable String apiKey, @PathVariable UUID attractionId,
                           @PathVariable int adults,@PathVariable int children,
                           @PathVariable int nightsStay,@PathVariable int rewardsPoints) {
        return tripPricerService.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints).toString();
    }

}
