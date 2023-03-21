package ilsia.sabirzianova.drones.sheduledtasks;

import ilsia.sabirzianova.drones.services.DronesService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DronesScheduledTask {
    private DronesService dronesService;

    @Scheduled(fixedDelay = 5 * 60 * 1_000)
    public void checkBattery() {
    }
}
