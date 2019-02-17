package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.model.Pet;

/**
 * Created by revin on 17.02.2019.
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
