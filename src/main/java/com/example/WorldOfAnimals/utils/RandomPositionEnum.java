package com.example.WorldOfAnimals.utils;


import com.example.WorldOfAnimals.models.Animals;
import org.springframework.stereotype.Service;

@Service
public class RandomPositionEnum {
    public int getAnimal() {
        return (int) (Math.random() * (Animals.values().length));
    }
}
