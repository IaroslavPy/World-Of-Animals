package com.example.WorldOfAnimals.services;


import com.example.WorldOfAnimals.models.AnimalBehavior;
import com.example.WorldOfAnimals.models.Animals;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnimalsService {

    private final Animals[] animals = Animals.values();

    public AnimalBehavior getAnimalBehavior(int randomAnimal) {
        return new AnimalBehavior(animals[randomAnimal].toString(),
                animals[randomAnimal].getBehavior());
    }

    public String getAnimals() {
        return Arrays.toString(animals);
    }

}
