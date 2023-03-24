package ilsia.sabirzianova.dcs.controller;

import ilsia.sabirzianova.dcs.model.Medication;
import ilsia.sabirzianova.dcs.model.jpa.entity.DroneEntity;
import ilsia.sabirzianova.dcs.model.jpa.entity.MedicationEntity;
import ilsia.sabirzianova.dcs.services.DronesService;
import ilsia.sabirzianova.dcs.services.MedicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drones")
public class DispatchController {
    private static final Logger log = LoggerFactory.getLogger(DispatchController.class);
    @Autowired
    DronesService dronesService;
    @Autowired
    MedicationService medicationService;

    @PostMapping("/register")
    public ResponseEntity<DroneEntity> register(@RequestBody DroneEntity drone) {
        DroneEntity created = dronesService.register(drone);
        if (created == null) {
            log.error("Drone {} can't be registered", drone.toString());
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

    @PostMapping("/load")
    public ResponseEntity<String> loadDrone(@RequestBody Map<String, String> json) {
        MedicationEntity medication = medicationService.findByCode(json.get("medicationCode"));
        if (medication == null) {
            log.error("Medication with code {} not found", json.get("medicationCode"));
            return ResponseEntity.noContent().build();
        }
        dronesService.load(json.get("droneSerialNum"), medicationService.convert(medication));
        return ResponseEntity.ok().body("Drone loaded");
    }

    @GetMapping(value = "/medication")
    public ResponseEntity<List<Medication>> checkMedication(HttpServletRequest request, @RequestParam String droneSerialNum) {
        List<Medication> medications = dronesService.getDroneMedicationList(droneSerialNum);
        for (Medication medication : medications) {
            medication.setImageUrl("http://localhost:18080/drones/show/medication?code=" + medication.getCode());
        }
        return ResponseEntity.ok().body(medications);
    }

    @RequestMapping(value = "/show/medication", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] showMedicationImage(@RequestParam("code") String medicationCode) {
        MedicationEntity medication = medicationService.findByCode(medicationCode);
        return medication.getLob().getImage();
    }

    public List<DroneEntity> checkAvailableDrones() {
        return null;
    }

    public void checkBattery(DroneEntity drone) {
    }

    @ControllerAdvice
    public static class ExceptionHandlerAdvice {
        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity handleException(RuntimeException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        }
    }
}
