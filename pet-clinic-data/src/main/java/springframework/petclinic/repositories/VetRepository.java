package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.model.Vet;

/**
 * Created by revin on 17.02.2019.
 */
public interface VetRepository extends CrudRepository<Vet, Long> {
}
