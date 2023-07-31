package com.example.WorldOfAnimals.mapper;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalTypeDTO;
import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalBreedMapper {

    public AnimalBreedEntity convertToEntity(AnimalBreedRequestDTO animalBreedRequestDTO) {
        AnimalBreedEntity animalBreed = new AnimalBreedEntity();
        AnimalTypeEntity animalType= new AnimalTypeEntity(
                animalBreedRequestDTO.getAnimalTypeDTO().getId(),
                animalBreedRequestDTO.getAnimalTypeDTO().getName());
        animalBreed.setName(animalBreedRequestDTO.getName());
        animalBreed.setType(animalType);
        return animalBreed;
    }

    public List<AnimalBreedDTO> convertToDTOs(List<AnimalBreedEntity> animalBreeds) {

        return animalBreeds.stream().map(entity ->
        {
            return new AnimalBreedDTO(entity.getId(), entity.getName(),
                    new AnimalTypeDTO(entity.getType().getId(),entity.getType().getName()));
        }).toList();
    }
}
