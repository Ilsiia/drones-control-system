package ilsia.sabirzianova.drones.services;

import org.springframework.scheduling.annotation.Scheduled;

public class DronesServiceImpl {

    @Scheduled(fixedDelay = 10 * 60 * 1_000)
    void checkBattery() {

    }
}
