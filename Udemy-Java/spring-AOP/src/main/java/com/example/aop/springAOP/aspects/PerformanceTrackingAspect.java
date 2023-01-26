package com.example.aop.springAOP.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("execution(* com.example.aop.springAOP.*.*.*(..))") //before and after execution
    @Around("com.example.aop.springAOP.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long stopTime = System.currentTimeMillis();

        long executionTime = stopTime - startTime;

        logger.info("Around aspect - {} method executed in {} ms", proceedingJoinPoint, executionTime);

        return returnValue;
    }
}
