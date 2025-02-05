package com.tripMaster.GpsUtil.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
/**
 * Implementation of GpsUtil Service
 * This class return a list of attractions and a visited location for a given user
 */
@Service
public class GpsUtilServiceImpl implements GpsUtilService{


    private final GpsUtil gpsUtil = new GpsUtil();

    @Override
    public VisitedLocation getUserLocation(UUID userId) {
        return gpsUtil.getUserLocation(userId);
    }

    @Override
    public List<Attraction> getAttractions() {
        return gpsUtil.getAttractions();
    }
}
