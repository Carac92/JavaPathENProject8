package tourGuide;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tourGuide.helper.InternalTestHelper;
import tourGuide.model.Attraction;
import tourGuide.model.VisitedLocation;
import tourGuide.repository.GpsUtilProxy;
import tourGuide.repository.RewardsProxy;
import tourGuide.service.RewardsService;
import tourGuide.service.TourGuideService;
import tourGuide.user.User;
import tourGuide.user.UserReward;
@ExtendWith(SpringExtension.class)
public class TestRewardsService {

	@InjectMocks
	private RewardsService rewardsService;
	@Mock
	private GpsUtilProxy gpsUtil;
	@Mock
	private RewardsProxy rewards;

	@Test
	public void userGetRewards() {

		InternalTestHelper.setInternalUserNumber(0);
		TourGuideService tourGuideService = new TourGuideService(gpsUtil, rewardsService);
		
		User user = new User(UUID.randomUUID(), "jon", "000", "jon@tourGuide.com");
		Attraction attraction = gpsUtil.getAttractions().get(0);
		user.addToVisitedLocations(new VisitedLocation(user.getUserId(), attraction, new Date()));
		tourGuideService.trackUserLocation(user);
		List<UserReward> userRewards = user.getUserRewards();
		tourGuideService.tracker.stopTracking();
		assertTrue(userRewards.size() == 1);
	}
	
	@Test
	public void isWithinAttractionProximity() {
		Attraction attraction = gpsUtil.getAttractions().get(0);
		assertTrue(rewardsService.isWithinAttractionProximity(attraction, attraction));
	}
	
	@Ignore // Needs fixed - can throw ConcurrentModificationException
	@Test
	public void nearAllAttractions() {
		rewardsService.setProximityBuffer(Integer.MAX_VALUE);

		InternalTestHelper.setInternalUserNumber(1);
		TourGuideService tourGuideService = new TourGuideService(gpsUtil, rewardsService);
		
		rewardsService.calculateRewards(tourGuideService.getAllUsers().get(0));
		List<UserReward> userRewards = tourGuideService.getUserRewards(tourGuideService.getAllUsers().get(0));
		tourGuideService.tracker.stopTracking();

		assertEquals(gpsUtil.getAttractions().size(), userRewards.size());
	}
	
}
