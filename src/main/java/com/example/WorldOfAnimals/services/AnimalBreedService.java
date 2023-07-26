package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
import com.example.WorldOfAnimals.mapper.AnimalBreedMapper;
import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.repositories.AnimalBreedRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnimalBreedService {

    private AnimalBreedRepository repository;
    private AnimalBreedMapper mapper;

    @Transactional
    public void save(AnimalBreedRequestDTO animalBreedRequestDTO) {
        AnimalBreedEntity animalBreed = mapper.convertToEntity(animalBreedRequestDTO);
        repository.save(animalBreed);
    }

    public List<AnimalBreedEntity> getAnimalsBreeds() {
        return new ArrayList<>(repository.findAll());
    }

    public List<AnimalBreedEntity> getAnimalsBreedsPage(Integer pageNo, Integer size) {
        PageRequest page = PageRequest.of(pageNo, size);
        Page<AnimalBreedEntity> pageResult = repository.findAll(page);
        return pageResult.getContent();
    }

    public void deleteByID(Integer id) {
        repository.deleteById(id);
    }
}
