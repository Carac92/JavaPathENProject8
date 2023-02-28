package com.tripMaster.Rewards.service;

import java.util.UUID;

/**
 * Interface for Rewards Service
 */
public interface RewardsService {

    int getAttractionRewardPoints(UUID attractionId, UUID userId);
}
