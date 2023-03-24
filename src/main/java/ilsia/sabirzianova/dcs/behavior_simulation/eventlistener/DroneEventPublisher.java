package ilsia.sabirzianova.dcs.behavior_simulation.eventlistener;

import ilsia.sabirzianova.dcs.model.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DroneEventPublisher {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void publicDroneEvent(final String message, Drone drone) {
        DroneEvent droneEvent = new DroneEvent(this, drone, message);
        publisher.publishEvent(droneEvent);
    }
}
