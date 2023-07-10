package com.example.WorldOfAnimals.repositories;

import com.example.WorldOfAnimals.models.AnimalBreed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository <AnimalBreed, Integer> {
}
