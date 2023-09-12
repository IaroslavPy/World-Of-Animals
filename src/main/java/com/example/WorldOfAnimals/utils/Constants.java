package com.example.WorldOfAnimals.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    public final static String RESOURCE_URL = "https://dog.ceo/api/";

    @Value("${upload.imagePath}")
    public String UPLOAD_IMAGES_PATH;
}
