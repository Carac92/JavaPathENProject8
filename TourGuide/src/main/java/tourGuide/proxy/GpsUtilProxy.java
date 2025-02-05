package tourGuide.proxy;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tourGuide.model.Attraction;
import tourGuide.model.VisitedLocation;

import java.util.List;
import java.util.UUID;

/**
 * GpsUtilProxy class is used to expose the GpsUtil API to the application
 */
@FeignClient(name = "GpsUtilAPI", url = "${gpsUtilUrl}")
public interface GpsUtilProxy {
    @GetMapping(value = "/attractions")
    List<Attraction> getAttractions();
    @GetMapping(value = "/userLocation/{userId}")
    VisitedLocation getUserLocation(@PathVariable("userId") UUID userId);
}
