package springframework.petclinic.services.impl;

import org.springframework.stereotype.Service;
import springframework.petclinic.model.Pet;
import springframework.petclinic.repositories.PetRepository;
import springframework.petclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by revin on 18.02.2019.
 */

@Service
public class PetServiceImpl implements PetService {

    private  final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
