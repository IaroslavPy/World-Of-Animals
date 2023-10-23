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
    @Value("${openapi.dev-url}")
    private String devUrl;
    @Value("${openapi.dev-url-descr}")
    private String devUrlDescr;
    @Value("${openapi.prod-url}")
    private String prodUrl;
    @Value("${openapi.prod-url-descr}")
    private String prodUrlDescr;
    @Value("${openapi.dev-name}")
    private String devName;
    @Value("${openapi.dev-email}")
    private String devEmail;
    @Value("${openapi.app-name}")
    private String appName;
    @Value("${openapi.app-version}")
    private String appVersion;
    @Value("${openapi.app-descr}")
    private String appDescr;


    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription(devUrlDescr);

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription(prodUrlDescr);

        Contact contact = new Contact();
        contact.setEmail(devEmail);
        contact.setName(devName);

        Info info = new Info()
                .title(appName)
                .version(appVersion)
                .contact(contact)
                .description(appDescr);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
