package com.example.WorldOfAnimals.exceptions;

public class AnimalTypeNotFoundException extends RuntimeException{
    public AnimalTypeNotFoundException(String message) {
        super(message);
    }
}
