package org.elena.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Value("#{'${app.swagger-ui.api-version}'}")
    private String apiVersion;
    @Value("#{'${app.swagger-ui.api-title}'}")
    private String uiTitle;
    @Value("#{'${app.swagger-ui.api-description}'}")
    private String apiDescription;
    @Value("#{'${app.swagger-ui.contact-name}'}")
    private String contactName;
    @Value("#{'${app.swagger-ui.contact-email}'}")
    private String contactEmail;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(buildInfo());
    }

    private Info buildInfo() {
        return new Info()
                .version(apiVersion)
                .title(uiTitle)
                .description(apiDescription)
                .contact(new Contact().name(contactName).email(contactEmail));
    }
}
