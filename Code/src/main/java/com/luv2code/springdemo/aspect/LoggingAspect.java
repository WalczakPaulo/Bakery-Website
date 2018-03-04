package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {};

    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint) {

        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("________In @Before: calling: " + theMethod);

        Object[] args = joinPoint.getArgs();

        for(Object temp: args)
            myLogger.info("________Parameter: " + temp.toString());
    }

    @AfterReturning(pointcut="forAppFlow()",
                    returning="theResult")
    private void afterReturn(JoinPoint joinPoint, Object theResult) {
        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("_________In @AfterReturn: from: " + theMethod);
        myLogger.info("__________Result is: " + theResult);
    }

}
