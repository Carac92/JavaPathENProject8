package com.tripMaster.Rewards.service;

import org.springframework.stereotype.Service;
import rewardCentral.RewardCentral;

import java.util.UUID;
/**
 * Service class for Rewards
 * Return the reward points for a given attraction and user
 */
@Service
public class RewardsServiceImpl implements RewardsService {
    private final RewardCentral rewardCentral = new RewardCentral();

    @Override
    public int getAttractionRewardPoints(UUID attractionId, UUID userId) {
        return rewardCentral.getAttractionRewardPoints(attractionId, userId);
    }
}
