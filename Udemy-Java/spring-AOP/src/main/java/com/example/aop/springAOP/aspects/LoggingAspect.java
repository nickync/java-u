package com.example.aop.springAOP.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Before("execution(* com.example.aop.springAOP.business.*.*(..))")
    @Before("com.example.aop.springAOP.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint){
        logger.info("Before aspect - {} is called - with following arguments {}", joinPoint, joinPoint.getArgs());
    }

    @After("execution(* com.example.aop.springAOP.business.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
        logger.info("After aspect - {} is called - with following arguments {}", joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.aop.springAOP.business.*.*(..))",
            throwing = "exception")
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception){
        logger.info("After exception aspect - {} is thrown - with following exception {}", joinPoint, exception);
    }

    @AfterReturning(pointcut = "execution(* com.example.aop.springAOP.business.*.*(..))", returning = "result")
    public void logMethodCall(JoinPoint joinPoint, Object result){
        logger.info("After returning - {} is called - with following result {}", joinPoint, result);
    }
}
