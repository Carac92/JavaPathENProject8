package com.tripMaster.TripPricer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
public class TripPricerServiceTest {
    @InjectMocks
    private TripPricerServiceImpl tripPricerService;

    @Test
    public void testGetPrice() {
        //WHEN
        List<Provider> result = tripPricerService.getPrice("testApiKey", UUID.randomUUID(),
                1, 0, 3, 0);
        // THEN
        assertThat(result.size()).isEqualTo(5);
    }
}
