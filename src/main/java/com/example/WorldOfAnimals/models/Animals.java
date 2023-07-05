package com.example.WorldOfAnimals.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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

    private String behavior;
}
