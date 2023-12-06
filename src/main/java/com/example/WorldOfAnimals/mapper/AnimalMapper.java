package com.example.WorldOfAnimals.mapper;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestPutDTO;
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
        AnimalTypeDTO animalTypeDTO = new AnimalTypeDTO(animal.getAnimalBreedEntity().getType().getId(),
                animal.getAnimalBreedEntity().getType().getName());
        AnimalBreedDTO animalBreedDTO = new AnimalBreedDTO(animal.getAnimalBreedEntity().getId(),
                animal.getAnimalBreedEntity().getName(), animalTypeDTO);
        return new AnimalDTO(animal.getId(), animal.getName(), animal.getSex(), animal.getAge(),
                animal.getSize(), animal.getDescription(), animalBreedDTO, animal.getCreated(),
                animal.getUpdated());
    }

    public List<AnimalDTO> convertToDTOs(List<AnimalEntity> animals) {
        return animals.stream().map(entity -> {
            AnimalTypeDTO animalTypeDTO = new AnimalTypeDTO(entity.getAnimalBreedEntity().getType().getId(),
                    entity.getAnimalBreedEntity().getType().getName());
            AnimalBreedDTO animalBreedDTO = new AnimalBreedDTO(entity.getAnimalBreedEntity().getId(),
                    entity.getAnimalBreedEntity().getName(), animalTypeDTO);
            return new AnimalDTO(entity.getId(), entity.getName(), entity.getSex(), entity.getAge(),
                    entity.getSize(), entity.getDescription(), animalBreedDTO, entity.getCreated(),
                    entity.getUpdated());
        }).toList();
    }

    public AnimalEntity convertToEntityPost(AnimalRequestDTO animalRequestDTO) {
        AnimalTypeEntity animalType = new AnimalTypeEntity
                (animalRequestDTO.getAnimalBreedDTO().getAnimalTypeDTO().getId(),
                        animalRequestDTO.getAnimalBreedDTO().getAnimalTypeDTO().getName());
        AnimalBreedEntity animalBreed = new AnimalBreedEntity(animalRequestDTO.getAnimalBreedDTO().getId(),
                animalRequestDTO.getAnimalBreedDTO().getName(), animalType);
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setName(animalRequestDTO.getName());
        animalEntity.setSex(animalRequestDTO.getSex());
        animalEntity.setAge(animalRequestDTO.getAge());
        animalEntity.setSize(animalRequestDTO.getSize());
        animalEntity.setDescription(animalRequestDTO.getDescription());
        animalEntity.setAnimalBreedEntity(animalBreed);
        animalEntity.setCreated(new Timestamp(System.currentTimeMillis()));
        animalEntity.setUpdated(new Timestamp(System.currentTimeMillis()));
        return animalEntity;
    }

    public AnimalEntity convertToEntityPut(AnimalRequestPutDTO animalRequestPutDTO) {
        AnimalTypeEntity animalType = new AnimalTypeEntity(
                animalRequestPutDTO.getAnimalBreedDTO().getAnimalTypeDTO().getId(),
                animalRequestPutDTO.getAnimalBreedDTO().getAnimalTypeDTO().getName());
        AnimalBreedEntity animalBreed = new AnimalBreedEntity(animalRequestPutDTO.getAnimalBreedDTO().getId(),
                animalRequestPutDTO.getAnimalBreedDTO().getName(), animalType);
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setId(animalRequestPutDTO.getId());
        animalEntity.setName(animalRequestPutDTO.getName());
        animalEntity.setSex(animalRequestPutDTO.getSex());
        animalEntity.setAge(animalRequestPutDTO.getAge());
        animalEntity.setSize(animalRequestPutDTO.getSize());
        animalEntity.setDescription(animalRequestPutDTO.getDescription());
        animalEntity.setAnimalBreedEntity(animalBreed);
        animalEntity.setUpdated(new Timestamp(System.currentTimeMillis()));
        return animalEntity;
    }
}
