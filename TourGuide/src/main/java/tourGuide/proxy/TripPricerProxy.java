package tourGuide.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tourGuide.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * TripPricerProxy class is used to expose the TripPricer API to the application
 */
@FeignClient(name = "TripPricerAPI", url = "${tripPricerUrl}")
public interface TripPricerProxy {
    @GetMapping("/getPrice/{apiKey}/{attractionId}/{adults}/{children}/{nightsStay}/{rewardsPoints}")
    List<Provider> getPrice(@PathVariable("apiKey") String apiKey, @PathVariable("attractionId") UUID attractionId,
                            @PathVariable("adults") int adults,@PathVariable("children") int children,
                            @PathVariable("nightsStay") int nightsStay,@PathVariable("rewardsPoints") int rewardsPoints);
}
