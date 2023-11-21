package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.dto.AnimalDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestPutDTO;
import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.mapper.AnimalMapper;
import com.example.WorldOfAnimals.models.AnimalEntity;
import com.example.WorldOfAnimals.repositories.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService {

    private final AnimalRepository repository;
    private final AnimalMapper mapper;

    @Transactional
    public void saveAnimal(AnimalRequestDTO animalRequestDTO) {
        repository.save(mapper.convertToEntityPost(animalRequestDTO));
    }

    public AnimalDTO getAnimalById(Long id) {
        return mapper.convertToDTO(repository.findById(id).orElseThrow(() ->
                new AnimalNotFoundException("Animal with ID " +
                        id + " not found!")));
    }

    public List<AnimalDTO> getAnimals() {
        return mapper.convertToDTOs(repository.findAll());
    }

    public List<AnimalDTO> getAllDogs() {
        return mapper.convertToDTOs(repository.getAllDogs());
    }

    public List<AnimalDTO> getAllCats() {
        return mapper.convertToDTOs(repository.getAllCats());
    }

    @Transactional
    public void updateAnimal(AnimalRequestPutDTO animalRequestPutDTO) {
        AnimalEntity entityFromBD = repository.findById(animalRequestPutDTO.getId()).orElseThrow(() ->
                new AnimalNotFoundException("Animal for updating with ID " +
                        animalRequestPutDTO.getId() + " - not found!"));
        AnimalEntity entityForUpdate = mapper.convertToEntityPut(animalRequestPutDTO);
        entityForUpdate.setCreated(entityFromBD.getCreated());
        repository.save(entityForUpdate);
    }

    @Transactional
    public void deleteAnimalById(Long id) {
        repository.deleteById(id);
    }
}
