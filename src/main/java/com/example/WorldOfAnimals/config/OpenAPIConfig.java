package com.example.WorldOfAnimals.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "openapi")
public class OpenAPIConfig {

    private String devName;

    private String devEmail;

    private Object appName;

    private String appVersion;

    private String appDescr;

    private List<String> serversUrl;

    private List<String> serversDescr;

    @Bean
    public OpenAPI myOpenAPI() {

        List<Server> servers = new ArrayList<>();

        for (int i = 0; i < serversUrl.size(); i++) {
            Server server = new Server();
            server.setUrl(serversUrl.get(i));
            server.setDescription(serversDescr.get(i));
            servers.add(server);
        }

        Contact contact = new Contact();
        contact.setEmail(devEmail);
        contact.setName(devName);

        Info info = new Info()
                .title((String) appName)
                .version(appVersion)
                .contact(contact)
                .description(appDescr);

        return new OpenAPI().info(info).servers(servers);
    }
}
