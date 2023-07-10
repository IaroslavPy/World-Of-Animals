package com.example.WorldOfAnimals.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnimalBreed {

    private int id;
    private String name;
    private AnimalTypeEntity type;
}
