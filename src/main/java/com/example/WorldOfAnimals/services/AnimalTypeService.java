package com.example.WorldOfAnimals.services;


import com.example.WorldOfAnimals.dto.AnimalTypeDTO;
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

    public void saveOrUpdate(AnimalTypeDTO animalTypeDTO) {
        repository.save(mapper.convertToEntity(animalTypeDTO));
    }

    public List<AnimalTypeDTO> getAnimalsType() {
        return mapper.convertToDTOs(new ArrayList<>(repository.findAll()));
    }

    @Transactional
    public AnimalTypeDTO getAnimalTypeById(Integer id) {
        return mapper.convertToDTO(repository.findById(id).orElseThrow(() ->
                new AnimalTypeNotFoundException("Animal type with ID "
                        + id + " not found!")));
    }

    public void deleteAnimalTypeById(Integer id) {
        repository.deleteById(id);
    }
}
