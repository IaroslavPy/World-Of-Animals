package com.example.WorldOfAnimals.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Animals {

    WOLF("I can bite!"),
    CAT("I can sleep!"),
    DOG("I can walk!"),
    RABBIT("I can eat!"),
    HORSE("I can ride"),
    COW("I make milk!"),
    FOX("I can run!"),
    SNAKE("I can see!"),
    LEOPARD("I can hunt"),
    SHEEP("I can sound");

    private final String behavior;

    public static Animals getAnimal(String type) {
        return Arrays.stream(Animals.values())
                .filter(animal -> animal.name().equals(type.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new AnimalNotFoundException("Not fund type=" + type));
    }
}
