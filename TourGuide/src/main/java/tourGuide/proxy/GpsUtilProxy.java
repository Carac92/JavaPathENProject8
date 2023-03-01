package tourGuide.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.w3c.dom.Attr;
import tourGuide.model.Attraction;
import tourGuide.model.VisitedLocation;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "GpsUtilAPI", url = "${gpsUtilUrl}")
public interface GpsUtilProxy {
    @GetMapping(value = "/attractions")
    List<Attraction> getAttractions();
    @GetMapping(value = "/userLocation/{userId}")
    VisitedLocation getUserLocation(@PathVariable("userId") UUID userId);
}
