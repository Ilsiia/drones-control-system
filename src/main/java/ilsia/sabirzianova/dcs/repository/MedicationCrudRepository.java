package ilsia.sabirzianova.dcs.repository;

import ilsia.sabirzianova.dcs.entity.MedicationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationCrudRepository extends CrudRepository<MedicationEntity, Long> {
}