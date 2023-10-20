package com.example.WorldOfAnimals.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Animal Breed Model for Response")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalBreedDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Breed ID")
    private Integer id;

    @Schema(description = "Breed name", example = "eskimo")
    private String name;

    @Schema(description = "Entity type of animal (ID and name)")
    private AnimalTypeDTO animalTypeDTO;
}
