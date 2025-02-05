package tourGuide.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

/**
 * RewardsProxy class is used to expose the Rewards API to the application
 */
@FeignClient(name = "RewardsAPI", url = "${rewardsUrl}")
public interface RewardsProxy {
    @GetMapping(value = "/getAttractionRewardPoints/{attractionId}/{userId}")
    int getAttractionRewardPoints(@PathVariable("attractionId") UUID attractionId,@PathVariable("userId") UUID userId);
}
