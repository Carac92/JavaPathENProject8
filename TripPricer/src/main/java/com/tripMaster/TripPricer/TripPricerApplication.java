package com.tripMaster.TripPricer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for TripPricer application used by TourGuide application
 * API that returns a list of providers for a trip with their price
 */
@SpringBootApplication
public class TripPricerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripPricerApplication.class, args);
	}

}
