package com.gapperdan.hsbmdc.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gapperdan.hsbmdc.bo.Greeting;
import com.gapperdan.hsbmdc.service.RandomGeneratorService;

@RestController
public class GreetingController {
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private RandomGeneratorService randomGeneratorService;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info("event=request received, nameParameter=" + name);
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name), randomGeneratorService.generate());		
		logger.info("event=request completed, response=" + greeting.toString());
		return greeting; 
	}
}