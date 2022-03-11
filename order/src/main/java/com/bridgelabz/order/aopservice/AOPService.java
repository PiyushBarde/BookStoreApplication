package com.bridgelabz.order.aopservice;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class AOPService {
    //logs method before hitting API
    @Before("execution(* com.bridgelabz.order.controller.OrderController.*(..))")    
    public void logBeforeV1(JoinPoint joinPoint) {
    	log.info("Initiating API : " + joinPoint.getSignature().getName() + " ");
    }

    //logs method After hitting API
    @After("execution(* com.bridgelabz.order.controller.OrderController.*(..))")     
    public void logAfter(JoinPoint joinPoint) {
    	log.info("API successfully Executed : " + joinPoint.getSignature().getName() + " ");
    }

    //logs method After hitting API
    @AfterReturning("execution(* com.bridgelabz.order.service.OrderService.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
    	log.info("Order returned to controller : " + joinPoint.getSignature().getName() + " ");
    }
    
    //logs parameters After hitting API
    @After("execution(* com.bridgelabz.order.controller.OrderController.*(..))")
    public void logAfterAndSaveArgs(JoinPoint joinPoint) {
    	log.info("After : " + Arrays.toString(joinPoint.getArgs()));
    }
}