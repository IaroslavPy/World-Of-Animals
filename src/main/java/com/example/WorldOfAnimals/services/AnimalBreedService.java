package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.dto.AnimalBreedDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalBreedResourceDTO;
import com.example.WorldOfAnimals.mapper.AnimalBreedMapper;
import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import com.example.WorldOfAnimals.repositories.AnimalBreedRepository;
import com.example.WorldOfAnimals.utils.Constants;
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
import java.util.Map;

@Service
@AllArgsConstructor
public class AnimalBreedService {

    private AnimalBreedRepository repository;
    private AnimalBreedMapper mapper;

    @Transactional
    public void saveBreeds(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(Constants.RESOURCE_URL, String.class);
        String json = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            AnimalBreedResourceDTO animalBreedRequestDTO = objectMapper.readValue(json, AnimalBreedResourceDTO.class);
            mapper.convertToEntities(animalBreedRequestDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
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
