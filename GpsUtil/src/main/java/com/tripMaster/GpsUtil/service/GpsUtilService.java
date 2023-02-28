package com.tripMaster.GpsUtil.service;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

import java.util.List;
import java.util.UUID;

/**
 * Interface for GpsUtil Service
 */
public interface GpsUtilService {
    VisitedLocation getUserLocation(UUID userId);
    List<Attraction> getAttractions();
}
