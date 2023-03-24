package ilsia.sabirzianova.dcs.model.jpa.repository;

import ilsia.sabirzianova.dcs.model.jpa.entity.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryCrudRepository extends CrudRepository<History, Long> {
}
