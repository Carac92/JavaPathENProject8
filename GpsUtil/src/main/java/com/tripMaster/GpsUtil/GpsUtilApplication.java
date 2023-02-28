package com.tripMaster.GpsUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

/**
 * GpsUtil Application is used by the TourGuide application to get the location of a user
 * and the list of attractions
 */
@SpringBootApplication
public class GpsUtilApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		SpringApplication.run(GpsUtilApplication.class, args);
	}

}
