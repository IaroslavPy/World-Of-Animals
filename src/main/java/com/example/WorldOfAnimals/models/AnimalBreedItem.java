package com.example.WorldOfAnimals.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AnimalBreedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int breedId;

    @Column
    private int breedItemId;
}
