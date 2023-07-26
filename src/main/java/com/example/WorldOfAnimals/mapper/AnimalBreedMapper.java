package com.example.WorldOfAnimals.mapper;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalBreedMapper {

    public AnimalBreedEntity convertToEntity(AnimalBreedRequestDTO animalBreedRequestDTO) {
        AnimalBreedEntity animalBreed = new AnimalBreedEntity();
        animalBreed.setName(animalBreedRequestDTO.getName());
        animalBreed.setType(animalBreedRequestDTO.getAnimalType());
        return animalBreed;
    }

    public List<AnimalBreedDTO> convertToDTOs(List<AnimalBreedEntity> animalBreeds) {
        return animalBreeds.stream().map(entity ->
        {
            return new AnimalBreedDTO(entity.getId(), entity.getName(), entity.getType());
        }).toList();
    }
}
