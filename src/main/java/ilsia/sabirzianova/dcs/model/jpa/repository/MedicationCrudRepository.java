package ilsia.sabirzianova.dcs.model.jpa.repository;

import ilsia.sabirzianova.dcs.model.jpa.entity.MedicationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationCrudRepository extends CrudRepository<MedicationEntity, Long> {
    @Query("SELECT p FROM MedicationEntity p WHERE p.code = ?1")
    MedicationEntity findByCode(String code);
}
