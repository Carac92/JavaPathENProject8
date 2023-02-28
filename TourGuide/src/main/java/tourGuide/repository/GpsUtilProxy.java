package tourGuide.repository;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tourGuide.config.Proxy;

import java.util.List;
import java.util.UUID;

@Repository
public class GpsUtilProxy {

    @Autowired
    private Proxy proxy;

    public VisitedLocation getUserLocation(UUID userId) {
        String url = proxy.getGpsUtilUrl() + "/userLocation/" + userId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<VisitedLocation> responseEntity = restTemplate.exchange(url,
                org.springframework.http.HttpMethod.GET, null, VisitedLocation.class);
        return responseEntity.getBody();
    }

    public Iterable<Attraction> getAttractions() {
        String url = proxy.getGpsUtilUrl() + "/attractions";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Attraction>> responseEntity = restTemplate.exchange(url,
                org.springframework.http.HttpMethod.GET, null,
                new ParameterizedTypeReference<Iterable<Attraction>>() {});
        return responseEntity.getBody();
    }
}
