package com.tripMaster.Rewards.controller;

import com.tripMaster.Rewards.service.RewardsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
/**
 * Controller class for Rewards
 * Return the reward points for a given attraction and user
 */
@RestController
public class RewardsController {
    @Autowired
    private RewardsService rewardsService;

    @Operation(summary = "Get reward points for a given attraction and user")
    @GetMapping("/getAttractionRewardPoints/{attractionId}/{userId}")
    public int getAttractionRewardPoints(@PathVariable UUID attractionId,@PathVariable UUID userId) {
        return rewardsService.getAttractionRewardPoints(attractionId, userId);
    }

}
