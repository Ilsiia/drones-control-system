package ilsia.sabirzianova.dcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DCSApplication {
    public static void main(String[] args) {
        SpringApplication.run(DCSApplication.class, args);
    }
}
