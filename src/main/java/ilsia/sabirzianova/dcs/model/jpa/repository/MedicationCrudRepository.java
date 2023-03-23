package ilsia.sabirzianova.dcs.model.jpa.repository;

import ilsia.sabirzianova.dcs.model.jpa.entity.MedicationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationCrudRepository extends CrudRepository<MedicationEntity, Long> {
}
