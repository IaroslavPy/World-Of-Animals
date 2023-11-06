package com.example.WorldOfAnimals.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "openapi")
public class OpenApiProperties {

    private String devName;

    private String devEmail;

    private Object appName;

    private String appVersion;

    private String appDescr;

    private List<String> serversUrl;

    private List<String> serversDescr;
}
