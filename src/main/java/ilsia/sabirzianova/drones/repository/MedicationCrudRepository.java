package ilsia.sabirzianova.drones.repository;

import ilsia.sabirzianova.drones.entity.MedicationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationCrudRepository extends CrudRepository<MedicationEntity, Long> {
}
