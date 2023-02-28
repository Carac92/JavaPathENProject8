package com.tripMaster.Rewards.config;

import org.springframework.context.annotation.Bean;
import rewardCentral.RewardCentral;
/**
 * Configuration class for Rewards
 * Instantiate a Bean of rewardCentral object to be used in the application
 * RewardCentral is a third party library
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public RewardCentral rewardCentral() {
        return new RewardCentral();
    }
}
