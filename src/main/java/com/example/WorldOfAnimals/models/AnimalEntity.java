package com.example.WorldOfAnimals.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "animals")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Schema(description = "Enum - M = Male, F = Female", example = "F")
    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "age", nullable = false)
    private String age;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "breed_id")
    private AnimalBreedEntity animalBreedEntity;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Column(name = "updated", nullable = false)
    private Timestamp updated;
}

