package ilsia.sabirzianova.dcs.services;

import ilsia.sabirzianova.dcs.model.Drone;
import ilsia.sabirzianova.dcs.model.Medication;
import ilsia.sabirzianova.dcs.model.jpa.entity.DroneEntity;

import java.util.List;

public interface DronesService {
    DroneEntity register(DroneEntity drone);// registering a drone;

    void load(String droneSerialNum, Medication medication);

    List<Medication> getDroneMedicationList(String droneSerialNum);

    List<Drone> getAvailableDrones();

    Integer checkBatteryLevel(String droneSerialNum);

    void nextState(Drone drone);
}
