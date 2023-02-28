package com.tripMaster.TripPricer.config;

import org.springframework.context.annotation.Bean;
import tripPricer.TripPricer;

@org.springframework.context.annotation.Configuration
public class Configuration {

        @Bean
        public TripPricer tripPricer() {
            return new TripPricer();
        }
}
