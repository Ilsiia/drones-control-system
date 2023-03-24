package ilsia.sabirzianova.dcs.model.jpa.repository;

import ilsia.sabirzianova.dcs.model.jpa.entity.DroneEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneCrudRepository extends CrudRepository<DroneEntity, Long> {
    @Query("SELECT p FROM DroneEntity p WHERE p.serialNumber = ?1")
    DroneEntity findBySerialNumber(String serialNumber);
}
