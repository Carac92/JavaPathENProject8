package tourGuide.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tourGuide.config.CustomProxy;
import tourGuide.model.Attraction;
import tourGuide.model.VisitedLocation;

import java.util.List;
import java.util.UUID;

@Component
public class GpsUtilProxy {

    @Autowired
    private CustomProxy customProxy;

    public VisitedLocation getUserLocation(UUID userId) {
        String url = customProxy.getGpsUtilUrl() + "/userLocation/" + userId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<VisitedLocation> responseEntity = restTemplate.exchange(url,
                org.springframework.http.HttpMethod.GET, null, VisitedLocation.class);
        return responseEntity.getBody();
    }

    public List<Attraction> getAttractions() {
        String baseUrl = customProxy.getGpsUtilUrl();
        String url = baseUrl + "/attractions";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Attraction>> responseEntity = restTemplate.exchange(url,
                org.springframework.http.HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Attraction>>() {});
        return responseEntity.getBody();
    }
}
