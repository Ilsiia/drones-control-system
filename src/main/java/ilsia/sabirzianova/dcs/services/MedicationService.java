package ilsia.sabirzianova.dcs.services;

import ilsia.sabirzianova.dcs.model.Medication;
import ilsia.sabirzianova.dcs.model.jpa.entity.MedicationEntity;

public interface MedicationService {
    void register(MedicationEntity medication) ;// registering a drone;
    MedicationEntity findByCode(String code);
    Medication convert(MedicationEntity entity);
}
