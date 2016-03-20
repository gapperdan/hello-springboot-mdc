package com.gapperdan.hsbmdc.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

import org.junit.Test;

public class RandomGeneratorServiceTest {
	
	@Test
	public void shouldReturnANumberBetween0and1000() {		
		int number = new RandomGeneratorService(1000).generate();
		assertThat(true, is(number <= 1000));		
	}
}
