package com.example.WorldOfAnimals.services;


import com.example.WorldOfAnimals.dto.AnimalTypeDTO;
import com.example.WorldOfAnimals.dto.AnimalTypeRequestDTO;
import com.example.WorldOfAnimals.exceptions.AnimalTypeNotFoundException;
import com.example.WorldOfAnimals.mapper.AnimalTypeMapper;
import com.example.WorldOfAnimals.repositories.AnimalTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnimalTypeService {

    private AnimalTypeRepository repository;
    private AnimalTypeMapper mapper;

    @Transactional
    public void saveAnimalType(AnimalTypeRequestDTO animalTypeRequestDTO) {
        repository.save(mapper.convertToEntityPost(animalTypeRequestDTO));
    }

    public List<AnimalTypeDTO> getAnimalsType() {
        return mapper.convertToDTOs(new ArrayList<>(repository.findAll()));
    }

    public AnimalTypeDTO getAnimalTypeById(Integer id) {
        return mapper.convertToDTO(repository.findById(id).orElseThrow(() ->
                new AnimalTypeNotFoundException("Animal type with ID "
                        + id + " not found!")));
    }

    @Transactional
    public void updateAnimalType(AnimalTypeDTO animalTypeDTO) {
        repository.save(mapper.convertToEntity(animalTypeDTO));
    }

    @Transactional
    public void deleteAnimalTypeById(Integer id) {
        repository.deleteById(id);
    }
}
