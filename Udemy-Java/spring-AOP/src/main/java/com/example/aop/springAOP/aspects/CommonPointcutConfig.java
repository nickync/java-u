package com.example.aop.springAOP.aspects;


import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.example.aop.springAOP.*.*.*(..))")
    public void businessPackageConfig(){

    }

    @Pointcut("@annotation(com.example.aop.springAOP.annotations.TrackTime)")
    public void trackTimeAnnotation(){

    }
}
