package com.example.WorldOfAnimals.services;


import com.example.WorldOfAnimals.models.AnimalBehavior;
import com.example.WorldOfAnimals.models.Animals;
import com.example.WorldOfAnimals.models.AnimalsGroup;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnimalsService {

    public AnimalBehavior getAnimalBehavior(String animalName) {
        Animals animal = Animals.getAnimal(animalName);
        return new AnimalBehavior(animalName, animal.getBehavior());
    }

    public AnimalsGroup getAnimals() {
        return new AnimalsGroup(Arrays.toString(animals));
    }
}
