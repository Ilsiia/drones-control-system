package ilsia.sabirzianova.dcs.behavior_simulation.eventlistener;

import ilsia.sabirzianova.dcs.model.Drone;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class DroneEvent extends ApplicationEvent {
    private String message;
    private Drone drone;

    public DroneEvent(Object source, Drone drone, String message) {
        super(source);
        this.message = message;
        this.drone = drone;
    }

    public DroneEvent(Object source, Clock clock) {
        super(source, clock);
    }

    public String getMessage() {
        return message;
    }

    public Drone getDrone() {
        return drone;
    }
}
