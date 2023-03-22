package ilsia.sabirzianova.dcs.services;

import ilsia.sabirzianova.dcs.entity.DroneEntity;
import ilsia.sabirzianova.dcs.model.Drone;
import ilsia.sabirzianova.dcs.repository.DroneCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("droneService")
public class DronesServiceImpl implements DronesService {
    @Autowired
    private DroneCrudRepository droneCrudRepository;

    @Override
    public DroneEntity register(DroneEntity drone) {
        return droneCrudRepository.save(drone);
    }

    private DroneEntity createEntity(Drone drone) {
        return new DroneEntity(drone.getSerialNumber(), drone.getModel(), drone.getWeightLimit());
    }
}
