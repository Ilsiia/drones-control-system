package ilsia.sabirzianova.dcs.model.jpa.repository;

import ilsia.sabirzianova.dcs.model.jpa.entity.DroneEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneCrudRepository extends CrudRepository<DroneEntity, Long> {
}
