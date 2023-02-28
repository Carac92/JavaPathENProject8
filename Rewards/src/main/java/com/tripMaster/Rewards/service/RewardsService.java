package com.tripMaster.Rewards.service;

import java.util.UUID;

public interface RewardsService {

    int getAttractionRewardPoints(UUID attractionId, UUID userId);
}
