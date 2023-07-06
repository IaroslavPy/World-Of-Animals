package com.example.WorldOfAnimals.services;


import com.example.WorldOfAnimals.models.AnimalBehavior;
import com.example.WorldOfAnimals.models.Animals;
import com.example.WorldOfAnimals.models.AnimalsGroup;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnimalsService {

    private final Animals[] animals = Animals.values();

    public AnimalBehavior getAnimalBehavior(String animalName) {

        String[] animalsString = new String[animals.length];

        for (int i = 0; i < animalsString.length; i++) {
            animalsString[i] = animals[i].name();
        }

        if (Arrays.asList(animalsString).contains(animalName))
            return new AnimalBehavior(animalName,
                    Animals.valueOf(animalName).getBehavior());
        else return new AnimalBehavior(animalName + " - absent in base!",
                "Not exist!");
    }

    public AnimalsGroup getAnimals() {
        return new AnimalsGroup(Arrays.toString(animals));
    }
}
