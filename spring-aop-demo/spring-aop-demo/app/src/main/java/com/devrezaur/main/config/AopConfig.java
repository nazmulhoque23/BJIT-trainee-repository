package com.devrezaur.main.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
public class AopConfig {

    Logger logger = LoggerFactory.getLogger(AopConfig.class);

    @Before("execution(* com.devrezaur.main.model.ClassA.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("**** Staring - " + joinPoint.getSignature().getName());
        logger.info("**** With parameter - " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.devrezaur.main.model.ClassA.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("**** Finished - " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.devrezaur.main.model.ClassA.*(..))", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        logger.info("**** Finished - " + joinPoint.getSignature().getName());
        logger.info("**** Returned - " + result);
    }
}
