package com.example.WorldOfAnimals.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenAPIConfig {

    private final OpenApiProperties openApiProperties;

    public OpenAPIConfig(OpenApiProperties openApiProperties) {
        this.openApiProperties = openApiProperties;
    }

    @Bean
    public OpenAPI myOpenAPI() {

        List<Server> servers = new ArrayList<>();

        for (int i = 0; i < openApiProperties.getServersUrl().size(); i++) {
            Server server = new Server();
            server.setUrl(openApiProperties.getServersUrl().get(i));
            server.setDescription(openApiProperties.getServersDescr().get(i));
            servers.add(server);
        }

        Contact contact = new Contact();
        contact.setEmail(openApiProperties.getDevEmail());
        contact.setName(openApiProperties.getDevName());

        Info info = new Info()
                .title((String) openApiProperties.getAppName())
                .version(openApiProperties.getAppVersion())
                .contact(contact)
                .description(openApiProperties.getAppDescr());

        return new OpenAPI().info(info).servers(servers);
    }
}
