package com.gestionBiblioteca.gestionB.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Api for the gestion of the library", version = "1.0", description = "Api Documentation"))
public class OpenApiConfig {
}
