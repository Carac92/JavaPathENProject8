package com.tripMaster.Rewards.config;

import org.springframework.context.annotation.Bean;
import rewardCentral.RewardCentral;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public RewardCentral rewardCentral() {
        return new RewardCentral();
    }
}
