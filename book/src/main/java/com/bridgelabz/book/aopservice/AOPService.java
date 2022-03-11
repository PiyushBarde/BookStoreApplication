package com.bridgelabz.book.aopservice;



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
    @Before("execution(* com.bridgelabz.book.controller.BookController.*(..))")     //point-cut expression
    public void logBeforeV1(JoinPoint joinPoint) {
        log.info("Initiating API : " + joinPoint.getSignature().getName() + " ");
    }
    
    //logs method After hitting API
    @After("execution(* com.bridgelabz.book.controller.BookController.*(..))")     //point-cut expression
    public void logAfter(JoinPoint joinPoint) {
    	log.info("API successfully Executed : " + joinPoint.getSignature().getName() + " ");
    }
    
    //logs method After hitting API
    @AfterReturning("execution(* com.bridgelabz.book.Service.BookService.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
    	log.info("Book returned to controller : " + joinPoint.getSignature().getName() + " ");
    }
    
    //logs parameters After hitting API
    @After("execution(* com.bridgelabz.book.controller.BookController.*(..))")
    public void logAfterAndSaveArgs(JoinPoint joinPoint) {
    	log.info("After : " + Arrays.toString(joinPoint.getArgs()));
    }
}