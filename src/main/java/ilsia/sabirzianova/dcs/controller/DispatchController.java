package ilsia.sabirzianova.dcs.controller;

import ilsia.sabirzianova.dcs.entity.DroneEntity;
import ilsia.sabirzianova.dcs.entity.MedicationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DispatchController {
    private static final Logger log = LoggerFactory.getLogger(DispatchController.class);

    public void registerDrone(DroneEntity drone) {
    }

    public void loadDrone(Integer droneSerialNum, MedicationEntity medication) {
    }

    public void checkMedication(DroneEntity drone) {
    }

    public List<DroneEntity> checkAvailableDrones() {
        return null;
    }

    public void checkBattery(DroneEntity drone) {
    }
}