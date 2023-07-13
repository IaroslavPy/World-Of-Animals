package com.example.WorldOfAnimals.repositories;

import com.example.WorldOfAnimals.models.AnimalBreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository <AnimalBreedEntity, Integer> {
}
