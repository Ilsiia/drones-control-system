package ilsia.sabirzianova.dcs.repository;

import ilsia.sabirzianova.dcs.entity.DroneEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneCrudRepository extends CrudRepository<DroneEntity, Long> {
}
