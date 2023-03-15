package tourGuide.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tourGuide.proxy.GpsUtilProxy;
import tourGuide.proxy.RewardsProxy;
import tourGuide.proxy.TripPricerProxy;
import tourGuide.service.RewardsService;
/**
 * Configuration class for TourGuide
 * This class is used to configure the bean of RewardsService for the application
 * Autowired to the different proxy classes
 */
@Configuration
public class TourGuideModule {
	@Autowired
	private GpsUtilProxy gpsUtilProxy;
	@Autowired
	private RewardsProxy rewardsProxy;
	@Autowired
	private TripPricerProxy tripPricerProxy;

	
	@Bean
	public RewardsService getRewardsService() {
		return new RewardsService(gpsUtilProxy, rewardsProxy);
	}

	
}
