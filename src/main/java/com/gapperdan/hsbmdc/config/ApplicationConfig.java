package com.gapperdan.hsbmdc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.gapperdan.hsbmdc.service.RandomGeneratorService;

@Component
@Configuration
@ConfigurationProperties(prefix="service")
public class ApplicationConfig {
	
	private int maxRandomNumber;
	
	@Bean
	public RandomGeneratorService randomGeneratorService() {
		return new RandomGeneratorService(maxRandomNumber);
	}

	public int getMaxRandomNumber() {
		return maxRandomNumber;
	}

	public void setMaxRandomNumber(int maxRandomNumber) {
		this.maxRandomNumber = maxRandomNumber;
	}
}