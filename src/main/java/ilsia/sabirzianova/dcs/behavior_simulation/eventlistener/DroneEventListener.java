package ilsia.sabirzianova.dcs.behavior_simulation.eventlistener;

import ilsia.sabirzianova.dcs.model.Drone;
import ilsia.sabirzianova.dcs.model.enums.DroneState;
import ilsia.sabirzianova.dcs.services.DronesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class DroneEventListener implements ApplicationListener<DroneEvent> {
    @Autowired
    DronesService dronesService;
    ExecutorService executor = Executors.newFixedThreadPool(5);
    Logger log = LoggerFactory.getLogger(DroneEventListener.class);

    @Override
    public void onApplicationEvent(DroneEvent event) {
        Drone drone = event.getDrone();
        if (!DroneState.IDLE.equals(drone.getState())) {
            Runnable task = () -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(60 * 1000);
                    dronesService.nextState(drone);
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
            };
            executor.execute(task);
        }
    }
}