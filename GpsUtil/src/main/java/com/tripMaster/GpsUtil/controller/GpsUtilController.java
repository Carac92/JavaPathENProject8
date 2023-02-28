package com.tripMaster.GpsUtil.controller;

import com.tripMaster.GpsUtil.service.GpsUtilService;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
/**
 * Controller class for GpsUtil
 * This class is used to expose the GpsUtil service to the application
 */
@RestController
public class GpsUtilController {
    @Autowired
    private GpsUtilService gpsUtilService;

    @GetMapping("/userLocation/{userId}")
    public VisitedLocation getUserLocation(@PathVariable UUID userId) {
        return gpsUtilService.getUserLocation(userId);
    }
    @GetMapping("/attractions")
    public List<Attraction> getAttractions() {
        return gpsUtilService.getAttractions();
    }
}
