package com.example.WorldOfAnimals.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalBreedRequestPutDTO {

    private Integer id;
    private String name;

    @JsonProperty(value = "animalType")
    private AnimalTypeDTO animalTypeDTO;
}
