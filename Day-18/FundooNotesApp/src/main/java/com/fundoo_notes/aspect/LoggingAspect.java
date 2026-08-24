package com.fundoo_notes.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	@Around("execution(* com.fundoo_notes.service..*(..))")
	public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();

		String methodName = joinPoint.getSignature().getName();

		log.info("Method {} started", methodName);

		try {

			Object result = joinPoint.proceed();

			long executionTime = System.currentTimeMillis() - startTime;

			log.info("Method {} completed in {} ms", methodName, executionTime);

			return result;

		} catch (Exception exception) {

			log.error("Exception in method {}: {}", methodName, exception.getMessage());

			throw exception;
		}
	}
}