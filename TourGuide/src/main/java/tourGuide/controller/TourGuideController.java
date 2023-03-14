package tourGuide.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;


import tourGuide.model.Provider;
import tourGuide.model.VisitedLocation;
import tourGuide.service.TourGuideService;
import tourGuide.user.User;


@RestController
public class TourGuideController {

	@Autowired
	TourGuideService tourGuideService;

    @Operation(summary = "Returns a greeting message")
    @GetMapping("/")
    public String index() {
        return "Greetings from TourGuide!";
    }

    @Operation(summary = "Return a Location for a given username")
    @GetMapping("/getLocation")
    public String getLocation(@RequestParam String userName) {
    	VisitedLocation visitedLocation = tourGuideService.getUserLocation(getUser(userName));
		return JsonStream.serialize(visitedLocation.location);
    }
    
    //  TODO: Change this method to no longer return a List of Attractions.
 	//  Instead: Get the closest five tourist attractions to the user - no matter how far away they are.
 	//  Return a new JSON object that contains:
    	// Name of Tourist attraction, 
        // Tourist attractions lat/long, 
        // The user's location lat/long, 
        // The distance in miles between the user's location and each of the attractions.
        // The reward points for visiting each Attraction.
        //    Note: Attraction reward points can be gathered from RewardsCentral
    @Operation(summary = "Return the five nearest attractions for a given username")
    @GetMapping("/getNearbyAttractions")
    public String getTheFiveNearestAttractions(@RequestParam String userName) {
    	VisitedLocation visitedLocation = tourGuideService.getUserLocation(getUser(userName));
    	return JsonStream.serialize(tourGuideService.getTheFiveNearByAttractionsDTO(visitedLocation, getUser(userName)).toString());
    }

    @Operation(summary = "Return the rewards for a given username")
    @GetMapping("/getRewards")
    public String getRewards(@RequestParam String userName) {
    	return JsonStream.serialize(tourGuideService.getUserRewards(getUser(userName)));
    }

    @Operation(summary = "Return a list of all users id with their last known location")
    @GetMapping("/getAllCurrentLocations")
    public String getAllCurrentLocations() {
    	// TODO: Get a list of every user's most recent location as JSON
    	//- Note: does not use gpsUtil to query for their current location, 
    	//        but rather gathers the user's current location from their stored location history.
    	//
    	// Return object should be the just a JSON mapping of userId to Locations similar to:
    	//     {
    	//        "019b04a9-067a-4c76-8817-ee75088c3822": {"longitude":-48.188821,"latitude":74.84371} 
    	//        ...
    	//     }
    	
    	return JsonStream.serialize(tourGuideService.getCurrentLocationsDTO().toString());
    }

    @Operation(summary = "Returns a list of providers for a given username")
    @GetMapping ("/getTripDeals")
    public String getTripDeals(@RequestParam String userName) {
    	List<Provider> providers = tourGuideService.getTripDeals(getUser(userName));
    	return JsonStream.serialize(providers);
    }
    
    private User getUser(String userName) {
    	return tourGuideService.getUser(userName);
    }
   

}