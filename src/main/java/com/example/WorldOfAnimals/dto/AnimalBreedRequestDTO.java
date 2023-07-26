package com.example.WorldOfAnimals.dto;

import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalBreedRequestDTO {

    private String name;

    private AnimalTypeEntity animalType;
}
