package com.gapperdan.hsbmdc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gapperdan.hsbmdc.service.RandomGeneratorService;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public RandomGeneratorService randomGeneratorService() {
		return new RandomGeneratorService();
	}
}