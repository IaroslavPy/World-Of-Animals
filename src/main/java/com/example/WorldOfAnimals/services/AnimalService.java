package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.models.AnimalEntity;
import com.example.WorldOfAnimals.repositories.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AnimalService {

   private final AnimalRepository repository;

   @Transactional
    public AnimalEntity getAnimalById(Long id){
       return repository.findById(id).orElseThrow(() ->
               new AnimalNotFoundException("Animal with ID " +
                       id + " not found!"));
    }

}
