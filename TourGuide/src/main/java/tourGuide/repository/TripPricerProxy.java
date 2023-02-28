package tourGuide.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tourGuide.config.Proxy;
import tripPricer.Provider;

import java.util.List;

@Repository
public class TripPricerProxy {
    @Autowired
    private Proxy proxy;

    public List<Provider> getPrice(String apiKey, int attractionId, int adults,
                                   int children, int nightsStay, int rewardsPoints) {
        String url = proxy.getTripPricerUrl() + "/getPrice/" + apiKey + "/" + attractionId +
                "/" + adults + "/" + children + "/" + nightsStay + "/" + rewardsPoints;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Provider>> responseEntity = restTemplate.exchange(url,
                org.springframework.http.HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Provider>>() {});
        return responseEntity.getBody();
    }
}
