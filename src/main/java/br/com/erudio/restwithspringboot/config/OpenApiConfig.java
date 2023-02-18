package br.com.erudio.restwithspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("RESTful API With Java 11 And Spring Boot 2.6.3")
						.version("v1")
						.description("RESTful API example")
						.termsOfService("https://www.openapis.org/")
						.license(new License()
								.name("Apache 2.0")
								.url("https://www.apache.org/")
								)
						);
		
	}
}
