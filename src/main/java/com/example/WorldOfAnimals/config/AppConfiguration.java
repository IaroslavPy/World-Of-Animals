package com.example.WorldOfAnimals.config;

import com.example.WorldOfAnimals.utils.Constants;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().rootUri(Constants.RESOURCE_URL).build();
    }
}
