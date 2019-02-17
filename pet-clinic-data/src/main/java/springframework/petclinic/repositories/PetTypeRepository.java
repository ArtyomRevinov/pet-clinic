package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.model.PetType;

/**
 * Created by revin on 17.02.2019.
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
