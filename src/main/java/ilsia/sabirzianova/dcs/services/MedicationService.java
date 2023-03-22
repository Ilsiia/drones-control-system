package ilsia.sabirzianova.dcs.services;

import ilsia.sabirzianova.dcs.exceptions.IllegalDataException;
import ilsia.sabirzianova.dcs.model.Medication;

public interface MedicationService {
    void register(Medication medication) throws IllegalDataException;// registering a drone;
}
