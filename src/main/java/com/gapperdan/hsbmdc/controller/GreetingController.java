package com.gapperdan.hsbmdc.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gapperdan.hsbmdc.bo.Greeting;
import com.gapperdan.hsbmdc.service.RandomGeneratorService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GreetingController {
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private RandomGeneratorService randomGeneratorService;

	@ApiOperation(value="")
	@ApiImplicitParams({
        @ApiImplicitParam(name="name",value="User's name",required=false,dataType="string",paramType="query",defaultValue="World")
      })
	@ApiResponses(value = {@ApiResponse(code=200,message="Success",response=Greeting.class)}) 
	@RequestMapping(value="/greeting",method=RequestMethod.GET, produces="application/json")
	public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name) {
		logger.info("event=request received, nameParameter=" + name);
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name), randomGeneratorService.generate());		
		logger.info("event=request completed, response=" + greeting.toString());
		return greeting; 
	}
}