package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedResourceDTO;
import com.example.WorldOfAnimals.mapper.AnimalBreedMapper;
import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.repositories.AnimalBreedRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnimalBreedService {

    private AnimalBreedRepository repository;
    private AnimalBreedMapper mapper;
    private ObjectMapper objectMapper;
    private RestTemplate restTemplate;

    @Transactional
    public void loadBreeds() {
        ResponseEntity<String> response = restTemplate.getForEntity("/breeds/list/all", String.class);
        String json = response.getBody();

        try {
            AnimalBreedResourceDTO animalBreedRequestDTO = objectMapper.readValue(json, AnimalBreedResourceDTO.class);
            List<AnimalBreedEntity> animalBreedsListFromResource = mapper.convertToEntities(animalBreedRequestDTO);
            List<AnimalBreedEntity> animalBreedsListFromBD = repository.findAll();
            List<AnimalBreedEntity> animalBreedsListResult = animalBreedsListFromResource.stream()
                    .filter(resourceBreed -> animalBreedsListFromBD.stream()
                            .noneMatch(bd -> bd.getName().equals(resourceBreed.getName())))
                    .collect(Collectors.toList());
            if (animalBreedsListResult.size() != 0) {
                repository.saveAll(animalBreedsListResult);
            }
        } catch (JsonProcessingException e) {
            e.getMessage();
        }
    }

    @Transactional
    public void save(AnimalBreedRequestDTO animalBreedRequestDTO) {
        AnimalBreedEntity animalBreed = mapper.convertToEntity(animalBreedRequestDTO);
        repository.save(animalBreed);
    }

    @Transactional
    public List<AnimalBreedDTO> getAnimalsBreeds() {
        return new ArrayList<>(mapper.convertToDTOs(repository.findAll()));
    }

    @Transactional
    public List<AnimalBreedDTO> getAnimalsBreedsPage(Integer pageNo, Integer size) {
        PageRequest page = PageRequest.of(pageNo, size);
        Page<AnimalBreedEntity> pageResult = repository.findAll(page);
        return mapper.convertToDTOs(pageResult.getContent());
    }

    public void deleteByID(Integer id) {
        repository.deleteById(id);
    }
}
