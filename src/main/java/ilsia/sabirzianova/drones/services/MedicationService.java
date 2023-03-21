package ilsia.sabirzianova.drones.services;

import ilsia.sabirzianova.drones.exceptions.IllegalDataException;
import ilsia.sabirzianova.drones.model.Medication;

public interface MedicationService {
    void register(Medication medication) throws IllegalDataException;// registering a drone;
}
