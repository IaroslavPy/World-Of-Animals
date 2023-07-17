package com.example.WorldOfAnimals.services;


import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.models.AnimalBehavior;
import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import com.example.WorldOfAnimals.models.Animals;
import com.example.WorldOfAnimals.models.AnimalsGroup;
import com.example.WorldOfAnimals.repositories.AnimalTypeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnimalTypeService {

 private AnimalTypeRepository repository;

 public List<AnimalTypeEntity> getAnimalsType() {
     return new ArrayList<>(repository.findAll());
    }
}
