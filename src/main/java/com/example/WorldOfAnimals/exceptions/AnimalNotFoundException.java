package com.example.WorldOfAnimals.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AnimalNotFoundException extends Exception{

    private String message;
}
