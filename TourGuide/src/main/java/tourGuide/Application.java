package tourGuide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


import java.util.Locale;

/**
 * Main class
 * This class is used to start the application
 * Application that connects to 3 APIS and generates different endpoints for the front end application
 */
@SpringBootApplication
@EnableFeignClients("tourGuide")
public class Application {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        SpringApplication.run(Application.class, args);
    }

}
