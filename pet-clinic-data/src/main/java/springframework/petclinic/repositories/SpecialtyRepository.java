package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.model.Specialty;

/**
 * Created by revin on 17.02.2019.
 */
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
