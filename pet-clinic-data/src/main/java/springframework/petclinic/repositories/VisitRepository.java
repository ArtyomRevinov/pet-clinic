package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.model.Visit;

/**
 * Created by revin on 17.02.2019.
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
