package com.example.WorldOfAnimals.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalFilter {

    @Schema(description = "Age of animals: Young ones, 1, 2, ...",
            example = "1", defaultValue = "Young ones")
    @Builder.Default
    private String age = "Young ones";

    @Schema(defaultValue = "Dog")
    @Builder.Default
    private String animalTypeName = "Dog";

    private String animalBreedName;

    @Schema(description = "Enum: M = Male, F = Female",
            example = "F", defaultValue = "M")
    @Builder.Default
    private String sex = "M";
}
