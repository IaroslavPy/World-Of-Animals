package com.example.WorldOfAnimals.repositories;

import com.example.WorldOfAnimals.models.AnimalTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalTypeRepository extends JpaRepository<AnimalTypeEntity, Integer> {

    AnimalTypeEntity save(AnimalTypeEntity animalType);

    List<AnimalTypeEntity> findAll();

    Optional<AnimalTypeEntity> findById(Integer id);

    void deleteById(Integer id);
}
