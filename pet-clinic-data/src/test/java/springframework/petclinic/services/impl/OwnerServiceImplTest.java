package springframework.petclinic.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import springframework.petclinic.model.Owner;
import springframework.petclinic.repositories.OwnerRepository;
import springframework.petclinic.repositories.PetRepository;
import springframework.petclinic.repositories.PetTypeRepository;
import springframework.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class OwnerServiceImplTest {

    public static final String LAST_NAME = "Smith";


    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    OwnerService ownerService;
    Owner returnOwner;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ownerService = new OwnerServiceImpl(ownerRepository, petRepository, petTypeRepository);
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    public void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(1L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    public void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    public void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerService.findById(1L);

        assertNull(owner);
    }


    @Test
    public void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    public void delete() {

        ownerService.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    public void deleteById() {

        ownerService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    public void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = ownerService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

    }
}