package com.example.WorldOfAnimals.repositories;

import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalTypeRepository extends CrudRepository<AnimalTypeEntity, Integer> {

    List<AnimalTypeEntity> findAll();
}
