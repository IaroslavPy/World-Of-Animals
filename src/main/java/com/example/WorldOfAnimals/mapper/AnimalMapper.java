package com.example.WorldOfAnimals.mapper;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalTypeDTO;
import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.models.AnimalEntity;
import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class AnimalMapper {

    public AnimalDTO convertToDTO(AnimalEntity animal) {
        AnimalTypeDTO animalTypeDTO = new AnimalTypeDTO(animal.getAnimalTypeEntity().getId(),
                animal.getAnimalTypeEntity().getName());
        AnimalBreedDTO animalBreedDTO = new AnimalBreedDTO(animal.getAnimalBreedEntity().getId(),
                animal.getAnimalBreedEntity().getName(), animalTypeDTO);
        return new AnimalDTO(animal.getId(), animal.getName(), animal.getDescription(),
                animalTypeDTO, animalBreedDTO, animal.getCreated(), animal.getUpdated());
    }

    public List<AnimalDTO> convertToDTOs(List<AnimalEntity> animals) {
        return animals.stream().map(entity -> {
            AnimalTypeDTO animalTypeDTO = new AnimalTypeDTO(entity.getAnimalTypeEntity().getId(),
                    entity.getAnimalTypeEntity().getName());
            AnimalBreedDTO animalBreedDTO = new AnimalBreedDTO(entity.getAnimalBreedEntity().getId(),
                    entity.getAnimalBreedEntity().getName(), animalTypeDTO);
            return new AnimalDTO(entity.getId(), entity.getName(), entity.getDescription(),
                    animalTypeDTO, animalBreedDTO, entity.getCreated(), entity.getUpdated());
        }).toList();
    }

    public AnimalEntity convertToEntityPost(AnimalRequestDTO animalRequestDTO) {
        AnimalTypeEntity animalType = new AnimalTypeEntity(animalRequestDTO.getAnimalTypeDTO().getId(),
                animalRequestDTO.getAnimalTypeDTO().getName());
        AnimalBreedEntity animalBreed = new AnimalBreedEntity(animalRequestDTO.getAnimalBreedDTO().getId(),
                animalRequestDTO.getAnimalBreedDTO().getName(), animalType);
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setName(animalRequestDTO.getName());
        animalEntity.setDescription(animalRequestDTO.getDescription());
        animalEntity.setAnimalTypeEntity(animalType);
        animalEntity.setAnimalBreedEntity(animalBreed);
        animalEntity.setCreated(new Timestamp(System.currentTimeMillis()));
        animalEntity.setUpdated(new Timestamp(System.currentTimeMillis()));
        return animalEntity;
    }
}
