package com.tripMaster.GpsUtil.config;

import gpsUtil.GpsUtil;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public GpsUtil gpsUtil() {
      return new GpsUtil();
    }

}
