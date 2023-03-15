package tourGuide.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix ="com.tripmaster")
public class CustomProxy {
    private String gpsUtilUrl;
    private String rewardsUrl;
    private String tripPricerUrl;

    public String getGpsUtilUrl() {
        return gpsUtilUrl;
    }
    public String getRewardsUrl() {
        return rewardsUrl;
    }
    public String getTripPricerUrl() {
        return tripPricerUrl;
    }

    public void setGpsUtilUrl(String gpsUtilUrl) {
        this.gpsUtilUrl = gpsUtilUrl;
    }

    public void setRewardsUrl(String rewardsUrl) {
        this.rewardsUrl = rewardsUrl;
    }

    public void setTripPricerUrl(String tripPricerUrl) {
        this.tripPricerUrl = tripPricerUrl;
    }
}
