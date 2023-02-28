package tourGuide.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tourGuide.config.CustomProxy;

import java.util.UUID;

@Component
public class RewardsProxy {
    @Autowired
    private CustomProxy customProxy;

    public int getAttractionRewardPoints(UUID attractionId, UUID userId) {
        String url = customProxy.getTripPricerUrl() + "/getAttractionRewardPoints/" + attractionId + "/" + userId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> responseEntity = restTemplate.exchange(url,
                org.springframework.http.HttpMethod.GET, null, Integer.class);
        try {
            return responseEntity.getBody();
        } catch (Exception e) {
            return 0;
        }
    }
}
