package com.example.WorldOfAnimals.mapper;

import com.example.WorldOfAnimals.dto.AnimalTypeDTO;
import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalTypeMapper {

    public AnimalTypeDTO convertToDTO(AnimalTypeEntity animalType){
        return new AnimalTypeDTO(animalType.getId(), animalType.getName());
    }

    public List<AnimalTypeDTO> convertToDTOs(List<AnimalTypeEntity> animalTypes){
        return animalTypes.stream().map(entity -> {
            return new AnimalTypeDTO(entity.getId(), entity.getName());
        }).toList();
    }

    public AnimalTypeEntity convertToEntity(AnimalTypeDTO animalTypeDTO){
        return new AnimalTypeEntity(animalTypeDTO.getId(), animalTypeDTO.getName());
    }
}
