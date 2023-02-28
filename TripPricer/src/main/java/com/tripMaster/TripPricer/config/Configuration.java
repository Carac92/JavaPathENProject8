package com.tripMaster.TripPricer.config;

import org.springframework.context.annotation.Bean;
import tripPricer.TripPricer;

/**
 * Configuration class for TripPricer
 * Create a bean of TripPricer object in library
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

        @Bean
        public TripPricer tripPricer() {
            return new TripPricer();
        }
}
