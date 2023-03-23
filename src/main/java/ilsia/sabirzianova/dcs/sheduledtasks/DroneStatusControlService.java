package ilsia.sabirzianova.dcs.sheduledtasks;

import ilsia.sabirzianova.dcs.model.Drone;
import ilsia.sabirzianova.dcs.services.DronesService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Component
public class DroneStatusControlService {

    private DronesService dronesService;
    Map<Long, Drone> activeDrones = new HashMap<>();

    @Scheduled(fixedDelay = 5 * 60 * 1_000)
    public void checkBattery() {
    }
}
