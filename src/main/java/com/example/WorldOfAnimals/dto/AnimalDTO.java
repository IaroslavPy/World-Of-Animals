package com.example.WorldOfAnimals.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnimalDTO {

    private Long id;

    private String name;

    @Schema(description = "Enum (one character) - M = Male, F = Female", example = "F")
    private String sex;

    private String age;

    private String size;

    private String description;

    private AnimalBreedDTO animalBreedDTO;

    private Timestamp created;

    private Timestamp updated;
}

