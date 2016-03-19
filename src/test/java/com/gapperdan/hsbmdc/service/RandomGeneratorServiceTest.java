package com.gapperdan.hsbmdc.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

import org.junit.Test;

public class RandomGeneratorServiceTest {
	
	final int MAX_NUMBER = 1000;

	@Test
	public void shouldReturnANumberBetween0and1000() {		
		RandomGeneratorService rgs = new RandomGeneratorService();
		int number = rgs.generate();			
		assertThat(true, is(number <= MAX_NUMBER));		
	}
}
