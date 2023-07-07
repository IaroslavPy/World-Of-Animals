package com.example.WorldOfAnimals.services;


import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.models.AnimalBehavior;
import com.example.WorldOfAnimals.models.Animals;
import com.example.WorldOfAnimals.models.AnimalsGroup;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class AnimalsService {

    public AnimalBehavior getAnimalBehavior(String animalName) throws AnimalNotFoundException {
        Animals animal = Animals.getAnimal(animalName);
        return new AnimalBehavior(animalName, animal.getBehavior());
    }

    public AnimalsGroup getAnimals() {
        String animals = Arrays.stream(Animals.values())
                .map(Enum::name)
                .collect(Collectors.joining(", "));
        return new AnimalsGroup(animals);
    }
}
