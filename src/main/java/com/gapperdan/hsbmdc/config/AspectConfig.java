package com.gapperdan.hsbmdc.config;

import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Configuration
public class AspectConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(AspectConfig.class);	
	private static final String REF_ID = "refId";
	
	@Before("execution(* com.gapperdan.hsbmdc.controller..*.*(..))")
	public void mdcPut(JoinPoint joinPoint) {
		logger.info("added mdc key before calling "+joinPoint.getSignature().getName()+"()");
		MDC.put(REF_ID, UUID.randomUUID().toString().replace("-", "").substring(0, 12));
	}	
	
	@After("execution(* com.gapperdan.hsbmdc.controller..*.*(..))")
	public void mdcRemove(JoinPoint joinPoint) {
		logger.info("removed mdc key after calling "+joinPoint.getSignature().getName()+"()");
		MDC.remove(REF_ID);
	}	
}