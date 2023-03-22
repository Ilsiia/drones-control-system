package ilsia.sabirzianova.dcs.controller;

import ilsia.sabirzianova.dcs.entity.DroneEntity;
import ilsia.sabirzianova.dcs.entity.MedicationEntity;
import ilsia.sabirzianova.dcs.services.DronesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/drones")
public class DispatchController {
    private static final Logger log = LoggerFactory.getLogger(DispatchController.class);
    @Autowired
    DronesService dronesService;

    @PostMapping("/register")
    public ResponseEntity<DroneEntity> register(@RequestBody DroneEntity drone) {
        DroneEntity created = dronesService.register(drone);
        if (created == null) {
            log.info("Drone {} can't be registered", drone.toString());
            return ResponseEntity.notFound().build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        log.info("Drone {} registered", created);
        return ResponseEntity.created(uri)
                .body(created);
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
