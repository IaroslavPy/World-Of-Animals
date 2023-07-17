package com.example.WorldOfAnimals.services;


import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import com.example.WorldOfAnimals.repositories.AnimalTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnimalTypeService {

 private AnimalTypeRepository repository;

 public List<AnimalTypeEntity> getAnimalsType() {
     return new ArrayList<>(repository.findAll());
    }

    public ResponseEntity<AnimalTypeEntity> getAnimalTypeById(Integer id){
        Optional<AnimalTypeEntity> animalType = repository.findById(id);

        return animalType.map(value ->
                ResponseEntity.ok().body(value)).orElseGet(() ->
                ResponseEntity.notFound().build());
    }
}
