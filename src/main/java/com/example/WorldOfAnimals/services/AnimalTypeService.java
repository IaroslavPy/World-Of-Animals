package com.example.WorldOfAnimals.services;


import com.example.WorldOfAnimals.exceptions.AnimalTypeNotFoundException;
import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import com.example.WorldOfAnimals.repositories.AnimalTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnimalTypeService {

    private AnimalTypeRepository repository;

    public AnimalTypeEntity saveOrUpdate(AnimalTypeEntity animalType) {
        return repository.save(animalType);
    }

    public List<AnimalTypeEntity> getAnimalsType() {
        return new ArrayList<>(repository.findAll());
    }

    public AnimalTypeEntity getAnimalTypeById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new AnimalTypeNotFoundException("Animal type with ID "
                        + id + " not found!"));
    }

    public void deleteAnimalTypeById(Integer id) {
        repository.deleteById(id);
    }
}
