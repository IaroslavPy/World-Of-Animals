package com.example.WorldOfAnimals.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnimalRequestDTO {

    private String name;

    private String description;

    @JsonProperty(value = "animalType")
    private AnimalTypeDTO animalTypeDTO;

    @JsonProperty(value = "animalBreed")
    private AnimalBreedDTO animalBreedDTO;
}

