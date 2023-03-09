package tourGuide;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tourGuide.helper.InternalTestHelper;
import tourGuide.model.Attraction;
import tourGuide.model.VisitedLocation;
import tourGuide.proxy.GpsUtilProxy;
import tourGuide.proxy.RewardsProxy;
import tourGuide.proxy.TripPricerProxy;
import tourGuide.service.RewardsService;
import tourGuide.service.TourGuideService;
import tourGuide.user.User;
import tourGuide.user.UserReward;
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RewardsServiceTest {
	@Autowired
	public GpsUtilProxy gpsUtil;
	@Autowired
	public RewardsProxy rewardsCentral;
	@Autowired
	public TripPricerProxy tripPricer;
	@Autowired
	public TourGuideService tourGuideService;

	@Test
	public void userGetRewardsTest() {
		RewardsService rewardsService = new RewardsService(gpsUtil, rewardsCentral);

		InternalTestHelper.setInternalUserNumber(0);
		TourGuideService tourGuideService = new TourGuideService(gpsUtil, rewardsService, tripPricer);
		
		User user = new User(UUID.randomUUID(), "jon", "000", "jon@tourGuide.com");
		Attraction attraction = gpsUtil.getAttractions().get(0);
		user.addToVisitedLocations(new VisitedLocation(user.getUserId(),attraction, new Date()));
		rewardsService.calculateRewards(user);
		List<UserReward> userRewards = user.getUserRewards();
		tourGuideService.tracker.stopTracking();
		assertTrue(userRewards.size() == 1);
	}
	
	@Test
	public void isWithinAttractionProximityTest() {
		RewardsService rewardsService = new RewardsService(gpsUtil, rewardsCentral);
		Attraction attraction = gpsUtil.getAttractions().get(0);
		assertTrue(rewardsService.isWithinAttractionProximity(attraction, attraction));
	}

	@Test
	public void nearAllAttractionsTest() {
		RewardsService rewardsService = new RewardsService(gpsUtil, rewardsCentral);
		rewardsService.setProximityBuffer(Integer.MAX_VALUE);
		InternalTestHelper.setInternalUserNumber(1);


		TourGuideService tourGuideService = new TourGuideService(gpsUtil, rewardsService, tripPricer);

		rewardsService.calculateRewards(tourGuideService.getAllUsers().get(0));
		List<UserReward> userRewards = tourGuideService.getUserRewards(tourGuideService.getAllUsers().get(0));
		tourGuideService.tracker.stopTracking();
		List<Attraction> attractions = gpsUtil.getAttractions();

		assertEquals(gpsUtil.getAttractions().size(), userRewards.size());
	}

}
