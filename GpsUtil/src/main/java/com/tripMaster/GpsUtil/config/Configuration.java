package com.tripMaster.GpsUtil.config;

import gpsUtil.GpsUtil;
import org.springframework.context.annotation.Bean;

/**
 * Configuration class for GpsUtil
 * Instantiate a Bean of GpsUtil object to be used in the application
 * GpsUtil is a third party library
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public GpsUtil gpsUtil() {
      return new GpsUtil();
    }

}
