package com.example.apirest1.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build().apiInfo(getApiInfo());
	}
	
	
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("Order Service API",
							"API for orders management", 
							"1.0", 
							"https://www.google.com", 
							new Contact("jorge garcia", "https://github.com/JcGarciaMed/", "jcgarciamed@gmail.com"), 
							"Licencia", 
							"Licencia URL",
							Collections.emptyList()
							);
	}
}
