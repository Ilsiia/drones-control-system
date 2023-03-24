package ilsia.sabirzianova.dcs.services;

import ilsia.sabirzianova.dcs.model.Drone;
import ilsia.sabirzianova.dcs.model.Medication;
import ilsia.sabirzianova.dcs.model.enums.DroneState;
import ilsia.sabirzianova.dcs.model.jpa.entity.DroneEntity;
import ilsia.sabirzianova.dcs.model.jpa.repository.DroneCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("droneService")
public class DronesServiceImpl implements DronesService {
    @Autowired
    private DroneCrudRepository droneCrudRepository;


    private final Map<String, Drone> activeDrones = new HashMap<>();

    @Override
    public DroneEntity register(DroneEntity entity) {
        DroneEntity created = droneCrudRepository.save(entity);
        Drone drone = new Drone(created.getSerialNumber(), 100, created.getModel(), created.getWeightLimit(), new ArrayList<>(), DroneState.IDLE);
        activeDrones.put(drone.getSerialNumber(), drone);
        return created;
    }

    @Override
    public void load(@NotNull String droneSerialNum, @NotNull Medication medication) {
        Drone drone = activeDrones.get(droneSerialNum);
        drone.load(medication);
    }

    @Override
    public List<Medication> getDroneMedicationList(@NotNull String droneSerialNum) {
        Drone drone = activeDrones.get(droneSerialNum);
        return drone.getMedications();
    }

    private DroneEntity createEntity(Drone drone) {
        return new DroneEntity(drone.getSerialNumber(), drone.getModel(), drone.getWeightLimit());
    }

    @PostConstruct
    private void mapDrones() {
        for (DroneEntity entity : droneCrudRepository.findAll()) {
            Drone drone = new Drone(entity.getSerialNumber(), 100, entity.getModel(), entity.getWeightLimit(), new ArrayList<>(), DroneState.IDLE);
            activeDrones.put(entity.getSerialNumber(), drone);
        }
    }
}
