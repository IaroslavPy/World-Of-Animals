package com.example.WorldOfAnimals.mapper;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestPutDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedResourceDTO;
import com.example.WorldOfAnimals.dto.AnimalTypeDTO;
import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


@Component
public class AnimalBreedMapper {

    public AnimalBreedEntity convertToEntity(AnimalBreedRequestDTO animalBreedRequestDTO) {
        AnimalBreedEntity animalBreed = new AnimalBreedEntity();
        AnimalTypeEntity animalType = new AnimalTypeEntity(
                animalBreedRequestDTO.getAnimalTypeDTO().getId(),
                animalBreedRequestDTO.getAnimalTypeDTO().getName());
        animalBreed.setName(animalBreedRequestDTO.getName());
        animalBreed.setType(animalType);
        return animalBreed;
    }

    public AnimalBreedEntity convertToEntityPut(AnimalBreedRequestPutDTO animalBreedRequestPutDTO) {
        AnimalBreedEntity animalBreed = new AnimalBreedEntity();
        AnimalTypeEntity animalType = new AnimalTypeEntity(
                animalBreedRequestPutDTO.getAnimalTypeDTO().getId(),
                animalBreedRequestPutDTO.getAnimalTypeDTO().getName());
        animalBreed.setId(animalBreedRequestPutDTO.getId());
        animalBreed.setName(animalBreedRequestPutDTO.getName());
        animalBreed.setType(animalType);
        return animalBreed;
    }

    public List<AnimalBreedDTO> convertToDTOs(List<AnimalBreedEntity> animalBreeds) {

        return animalBreeds.stream().map(entity ->
        {
            return new AnimalBreedDTO(entity.getId(), entity.getName(),
                    new AnimalTypeDTO(entity.getType().getId(), entity.getType().getName()));
        }).toList();
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
}
