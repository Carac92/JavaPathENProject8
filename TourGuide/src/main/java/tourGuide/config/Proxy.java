package tourGuide.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
@ConfigurationProperties(prefix ="com.tripmaster")
public class Proxy {
    private String gpsUtilUrl;
    private String rewardsUrl;
    private String tripPricerUrl;

}
