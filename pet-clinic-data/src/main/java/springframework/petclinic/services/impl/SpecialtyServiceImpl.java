package springframework.petclinic.services.impl;

import org.springframework.stereotype.Service;
import springframework.petclinic.model.Specialty;
import springframework.petclinic.repositories.SpecialtyRepository;
import springframework.petclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by revin on 18.02.2019.
 */

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
