package com.tripMaster.Rewards.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
public class RewardsServiceTest {
    @InjectMocks
    private RewardsServiceImpl rewardsService;

    @Test
    public void testGetAttractionRewardPoints() {
        // GIVEN
        // WHEN
        int result = rewardsService.getAttractionRewardPoints(UUID.randomUUID(), UUID.randomUUID());
        // THEN
        assertThat(result).isGreaterThan(0);
    }
}
