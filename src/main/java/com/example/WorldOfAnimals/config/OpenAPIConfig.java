package com.example.WorldOfAnimals.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Value("${devPi.openapi.dev-url}")
    private String devUrl;

    @Value("${devPi.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("iaroslavpylypchuk@gmail.com");
        contact.setName("devPi");

        Info info = new Info()
                .title("World of animals API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage animal images.");

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
