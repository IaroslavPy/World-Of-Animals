package com.example.WorldOfAnimals.services;

import com.example.WorldOfAnimals.dto.AnimalDTO;
import com.example.WorldOfAnimals.dto.AnimalRequestDTO;
import com.example.WorldOfAnimals.exceptions.AnimalNotFoundException;
import com.example.WorldOfAnimals.mapper.AnimalMapper;
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
    public void saveAnimal(AnimalRequestDTO animalRequestDTO){
        repository.save(mapper.convertToEntityPost(animalRequestDTO));
    }


   @Transactional
    public AnimalDTO getAnimalById(Long id){
       return mapper.convertToDTO(repository.findById(id).orElseThrow(() ->
               new AnimalNotFoundException("Animal with ID " +
                       id + " not found!")));
    }

    @Transactional
    public List<AnimalDTO> getAnimals(){
       return mapper.convertToDTOs(repository.findAll());
    }

    @Transactional
    public void deleteAnimalById(Long id){
       repository.deleteById(id);
    }

}
