package com.carolina;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
	
	Docket createApiRestDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.carolina"))
				.paths(PathSelectors.any())
				.build();
		
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Registro para adopción de mascotas")
				.description("Este registro permitira acceder al listado de mascotas y sus caracteristicas")
				.termsOfServiceUrl("https://github.com/carolina")
				.contact(new Contact("Carolina Orozco","www.carolina.com","corozco@gmail.com"))
				.build();
	}

}
