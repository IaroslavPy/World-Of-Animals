package com.example.WorldOfAnimals.repositories;

import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalTypeRepository extends CrudRepository<AnimalTypeEntity, Integer> {

    List<AnimalTypeEntity> findAll();

    Optional<AnimalTypeEntity> findById(Integer id);
}
