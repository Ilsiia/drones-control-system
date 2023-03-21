package ilsia.sabirzianova.drones.repository;

import ilsia.sabirzianova.drones.entity.DroneEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneCrudRepository extends CrudRepository<DroneEntity, Long> {
}
