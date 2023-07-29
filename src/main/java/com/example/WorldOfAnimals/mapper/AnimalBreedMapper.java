package com.example.WorldOfAnimals.mapper;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedResourceDTO;
import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class AnimalBreedMapper {

    public AnimalBreedEntity convertToEntity(AnimalBreedRequestDTO animalBreedRequestDTO) {
        AnimalBreedEntity animalBreed = new AnimalBreedEntity();
        animalBreed.setName(animalBreedRequestDTO.getName());
        animalBreed.setType(animalBreedRequestDTO.getAnimalType());
        return animalBreed;
    }

    public List<AnimalBreedEntity> convertToEntities(AnimalBreedResourceDTO animalBreedResourceDTO) {
        List<AnimalBreedEntity> animalBreeds = new ArrayList<>();
        AnimalTypeEntity animalType = new AnimalTypeEntity(1, "Dog");
        Map<String, List<String>> breeds = animalBreedResourceDTO.getBreeds();

        List<String> animalBreedsList = breeds.entrySet().stream()
                .flatMap(entry -> {
                    String key = entry.getKey();
                    List<String> values = entry.getValue();

                    if (values.isEmpty()) {
                        return Stream.of(key);
                    } else {
                        return values.stream().map(value -> key + " " + value);
                    }
                })
                .toList();

        for (String breed : animalBreedsList) {
            AnimalBreedEntity animalBreed = new AnimalBreedEntity();
            animalBreed.setName(breed);
            animalBreed.setType(animalType);
            animalBreeds.add(animalBreed);
        }
        return animalBreeds;
    }

    public List<AnimalBreedDTO> convertToDTOs(List<AnimalBreedEntity> animalBreeds) {
        return animalBreeds.stream().map(entity ->
        {
            return new AnimalBreedDTO(entity.getId(), entity.getName(), entity.getType());
        }).toList();
    }
}
