package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.dto.AnimalDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestPutDTO;
import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.mapper.AnimalMapper;
import com.example.WorldOfAnimals.models.AnimalEntity;
import com.example.WorldOfAnimals.repositories.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<AnimalDTO> getPaginatedAnimals(Pageable pageable) {
        Page<AnimalEntity> animalEntityPage = repository.findAll(pageable);
        List<AnimalDTO> animalDTOList = animalEntityPage.getContent().stream()
                .map(mapper::convertToDTO)
                .toList();
        return new PageImpl<>(animalDTOList, animalEntityPage.getPageable(),
                animalEntityPage.getTotalElements());
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
