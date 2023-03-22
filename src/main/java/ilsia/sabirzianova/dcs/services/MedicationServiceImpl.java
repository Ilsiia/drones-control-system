package ilsia.sabirzianova.dcs.services;

import ilsia.sabirzianova.dcs.entity.MedicationEntity;
import ilsia.sabirzianova.dcs.exceptions.IllegalDataException;
import ilsia.sabirzianova.dcs.model.Medication;
import ilsia.sabirzianova.dcs.repository.MedicationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationServiceImpl implements MedicationService {
    @Autowired
    MedicationCrudRepository repository;

    @Override
    public void register(Medication medication) throws IllegalDataException {
        repository.save(createEntity(medication));
    }
    private MedicationEntity createEntity(Medication medication) throws IllegalDataException {
        return new MedicationEntity(medication.getName(), medication.getWeight(), medication.getCode(), medication.getImage());
    }
}
