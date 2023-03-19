package ilsia.sabirzianova.drones.controller;

import ilsia.sabirzianova.drones.model.Drone;
import ilsia.sabirzianova.drones.model.Medication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DispatchController {
    private static final Logger log = LoggerFactory.getLogger(DispatchController.class);

    public void registerDrone(Drone drone) {
    }

    public void loadDrone(Integer droneSerialNum, Medication medication) {
    }

    public void checkMedication(Drone drone) {
    }

    public List<Drone> checkAvailableDrones() {
        return null;
    }

    public void checkBattery(Drone drone) {
    }
}
