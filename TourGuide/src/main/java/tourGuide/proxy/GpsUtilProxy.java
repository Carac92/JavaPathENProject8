package tourGuide.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Attr;
import tourGuide.model.Attraction;

import java.util.List;

@FeignClient(name = "GpsUtilAPI", url = "${gpsUtilUrl}")
public interface GpsUtilProxy {
    @GetMapping(value = "/getAttractions")
    List<Attraction> getAttractions();
}
