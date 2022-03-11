package com.bridgelabz.cart.aopservice;



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
    @Before("execution(* com.bridgelabz.cart.controller.CartController.*(..))")     
    public void logBeforeV1(JoinPoint joinPoint) {
        log.info("Initiating API : " + joinPoint.getSignature().getName() + " ");
    }
    
    //logs method After hitting API
    @After("execution(* com.bridgelabz.cart.controller.CartController.*(..))")     
    public void logAfter(JoinPoint joinPoint) {
    	log.info("API successfully Executed : " + joinPoint.getSignature().getName() + " ");
    }
    
    //logs method After hitting API
    @AfterReturning("execution(* com.bridgelabz.cart.service.CartService.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
    	log.info("Order returned to controller : " + joinPoint.getSignature().getName() + " ");
    }

    //logs parameters After hitting API
    @After("execution(* com.bridgelabz.cart.controller.CartController.*(..))")
    public void logAfterAndSaveArgs(JoinPoint joinPoint) {
    	log.info("After : " + Arrays.toString(joinPoint.getArgs()));
    }
}