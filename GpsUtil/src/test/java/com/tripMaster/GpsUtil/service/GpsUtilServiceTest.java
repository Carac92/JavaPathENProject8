package com.tripMaster.GpsUtil.service;

import com.tripMaster.GpsUtil.service.GpsUtilServiceImpl;
import gpsUtil.location.VisitedLocation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
public class GpsUtilServiceTest {
    @InjectMocks
    private GpsUtilServiceImpl gpsUtilService;

    @Test
    public void testGetUserLocation() {
        // GIVEN
        Locale.setDefault(Locale.US);
        UUID userId = UUID.randomUUID();
        //WHEN
        VisitedLocation visitedLocation = gpsUtilService.getUserLocation(userId);
        // THEN
        assertThat(visitedLocation.userId).isEqualTo(userId);
    }
    @Test
    public void testGetAttractions() {
        // GIVEN
        Locale.setDefault(Locale.US);
        //WHEN
        int size = gpsUtilService.getAttractions().size();
        // THEN
        assertThat(size).isEqualTo(26);
    }
}
