package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.repositories.AnimalBreedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnimalBreedService {

    private AnimalBreedRepository repository;

    public AnimalBreedEntity saveOrUpdate(AnimalBreedEntity animalBreed){
        return repository.save(animalBreed);
    }

    public List<AnimalBreedEntity> getAnimalsBreeds(){
        return new ArrayList<>(repository.findAll());
    }
}
