package ilsia.sabirzianova.drones.services;

import ilsia.sabirzianova.drones.entity.DroneEntity;
import ilsia.sabirzianova.drones.model.Drone;
import ilsia.sabirzianova.drones.repository.DroneCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("droneService")
public class DronesServiceImpl implements DronesService {
    @Autowired
    private DroneCrudRepository droneCrudRepository;

    @Override
    public void register(Drone drone) {
        droneCrudRepository.save(createEntity(drone));
    }

    private DroneEntity createEntity(Drone drone) {
        return new DroneEntity(drone.getSerialNumber(), drone.getModel(), drone.getWeightLimit());
    }
}
