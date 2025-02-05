package tourGuide.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tourGuide.dto.AttractionDTO;
import tourGuide.dto.CurrentLocationDTO;
import tourGuide.helper.InternalTestHelper;
import tourGuide.model.Attraction;
import tourGuide.model.Location;
import tourGuide.model.Provider;
import tourGuide.model.VisitedLocation;
import tourGuide.proxy.GpsUtilProxy;
import tourGuide.proxy.TripPricerProxy;
import tourGuide.tracker.Tracker;
import tourGuide.user.User;
import tourGuide.user.UserPreferences;
import tourGuide.user.UserReward;

/**
 * TourGuideService class is used to manage the users and their locations
 * It uses the GpsUtilProxy and TripPricerProxy to get the data
 * It uses the ExecutorService to track the user location with multithreading
 */
@Service
public class TourGuideService {
	private Logger logger = LoggerFactory.getLogger(TourGuideService.class);
	private final GpsUtilProxy gpsUtil;
	private final RewardsService rewardsService;
	private final TripPricerProxy tripPricer;
	public final Tracker tracker;
	private final ExecutorService executorService = Executors.newFixedThreadPool(100);
	boolean testMode = true;
	
	public TourGuideService(GpsUtilProxy gpsUtil, RewardsService rewardsService, TripPricerProxy tripPricer) {
		this.gpsUtil = gpsUtil;
		this.rewardsService = rewardsService;
		this.tripPricer = tripPricer;

		if(testMode) {
			logger.info("TestMode enabled");
			logger.debug("Initializing users");
			initializeInternalUsers();
			logger.debug("Finished initializing users");
		}
		tracker = new Tracker(this);
		addShutDownHook();
	}
	
	public List<UserReward> getUserRewards(User user) {
		return user.getUserRewards();
	}
	
	public VisitedLocation getUserLocation(User user) {
		VisitedLocation visitedLocation = (user.getVisitedLocations().size() > 0) ?
			user.getLastVisitedLocation() :
			trackUserLocation(user);
		return visitedLocation;
	}
	
	public User getUser(String userName) {
		return internalUserMap.get(userName);
	}
	
	public List<User> getAllUsers() {
		return internalUserMap.values().stream().collect(Collectors.toList());
	}
	
	public void addUser(User user) {
		if(!internalUserMap.containsKey(user.getUserName())) {
			internalUserMap.put(user.getUserName(), user);
		}
	}
	
	public List<Provider> getTripDeals(User user) {
		int cumulativeRewardPoints = user.getUserRewards().stream().mapToInt(UserReward::getRewardPoints).sum();
		List<Provider> providers = tripPricer.getPrice(
				tripPricerApiKey,
				user.getUserId(),
				user.getUserPreferences().getNumberOfAdults(),
				user.getUserPreferences().getNumberOfChildren(),
				user.getUserPreferences().getTripDuration(),
				cumulativeRewardPoints
		);
		user.setTripDeals(providers);
		return providers;
	}
	
	public VisitedLocation trackUserLocation(User user) {
		VisitedLocation visitedLocation = gpsUtil.getUserLocation(user.getUserId());
		user.addToVisitedLocations(visitedLocation);
		rewardsService.calculateRewardsAsync(user);
		return visitedLocation;
	}
	public void trackUserLocationAsync(User user) {
		executorService.execute(() -> trackUserLocation(user));
	}
	public void shutdown() throws InterruptedException {
		executorService.shutdown();
		try{
			if (!executorService.awaitTermination(15, TimeUnit.MINUTES)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			executorService.shutdownNow();
		}
	}
	public List<Attraction> getTheFiveNearByAttractions(VisitedLocation visitedLocation) {
		HashMap<Attraction,Double> nearbyAttractions = new HashMap<>();
		for(Attraction attraction : gpsUtil.getAttractions()) {
			double distance = rewardsService.getDistance(attraction, visitedLocation.location);
			nearbyAttractions.put(attraction, distance);
		}
		return nearbyAttractions.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.limit(5)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
	public List<AttractionDTO> getTheFiveNearByAttractionsDTO(VisitedLocation visitedLocation, User user){
		List<AttractionDTO> attractionDTOList = new ArrayList<>();
		List<Attraction> attractionList = getTheFiveNearByAttractions(visitedLocation);
		for(Attraction attraction : attractionList) {
			AttractionDTO attractionDTO = new AttractionDTO(
					attraction.latitude,
					attraction.longitude,
					attraction.attractionName,
					visitedLocation,
					rewardsService.getDistance(attraction, visitedLocation.getLocation()),
					rewardsService.getRewardPoints(attraction, user)
			);
			attractionDTOList.add(attractionDTO);
		}
		return attractionDTOList;
	}
	public List<CurrentLocationDTO> getCurrentLocationsDTO(){
		List<CurrentLocationDTO> currentLocationDTOList = new ArrayList<>();
		for(User user : getAllUsers()) {
			CurrentLocationDTO currentLocationDTO = new CurrentLocationDTO(
					user.getUserId(),
					user.getLastVisitedLocation().location.latitude,
					user.getLastVisitedLocation().location.longitude
			);
			currentLocationDTOList.add(currentLocationDTO);
		}
		return currentLocationDTOList;
	}

	public void updateUserPreferences(String userName, UserPreferences userPreferences) {
		User user = getUser(userName);
		user.setUserPreferences(userPreferences);
	}
	
	private void addShutDownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() { 
		      public void run() {
		        tracker.stopTracking();
		      } 
		    }); 
	}
	
	/**********************************************************************************
	 * 
	 * Methods Below: For Internal Testing
	 * 
	 **********************************************************************************/
	private static final String tripPricerApiKey = "test-server-api-key";
	// Database connection will be used for external users, but for testing purposes internal users are provided and stored in memory
	private final Map<String, User> internalUserMap = new HashMap<>();
	private void initializeInternalUsers() {
		IntStream.range(0, InternalTestHelper.getInternalUserNumber()).forEach(i -> {
			String userName = "internalUser" + i;
			String phone = "000";
			String email = userName + "@tourGuide.com";
			User user = new User(UUID.randomUUID(), userName, phone, email);
			generateUserLocationHistory(user);
			
			internalUserMap.put(userName, user);
		});
		logger.debug("Created " + InternalTestHelper.getInternalUserNumber() + " internal test users.");
	}
	
	private void generateUserLocationHistory(User user) {
		IntStream.range(0, 3).forEach(i-> {
			user.addToVisitedLocations(new VisitedLocation(
					user.getUserId(),
					new Location(
							generateRandomLatitude(),
							generateRandomLongitude()),
							getRandomTime()
					)
			);
		});
	}
	
	private double generateRandomLongitude() {
		double leftLimit = -180;
	    double rightLimit = 180;
	    return leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
	}
	
	private double generateRandomLatitude() {
		double leftLimit = -85.05112878;
	    double rightLimit = 85.05112878;
	    return leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
	}
	
	private Date getRandomTime() {
		LocalDateTime localDateTime = LocalDateTime.now().minusDays(new Random().nextInt(30));
	    return Date.from(localDateTime.toInstant(ZoneOffset.UTC));
	}
	
}
