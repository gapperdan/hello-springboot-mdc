package com.gapperdan.hsbmdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@EnableSwagger2
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}	

	@Bean
	public Docket appApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
				.apis(RequestHandlerSelectors
				.any())
				.paths(PathSelectors.regex("/greeting.*"))
			.build();
	}
}
