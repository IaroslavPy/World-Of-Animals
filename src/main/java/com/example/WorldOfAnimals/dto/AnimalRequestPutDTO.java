package com.example.WorldOfAnimals.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnimalRequestPutDTO {

    private Long id;

    private String name;

    private String description;

    private AnimalBreedDTO animalBreedDTO;
}

