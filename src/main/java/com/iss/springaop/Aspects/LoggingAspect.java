package com.iss.springaop.Aspects;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    // @Before("execution(public void callingShape()) || execution(public String getName())")
    // this above thing is about using multiple methods with  || operator
    // if we want to add this advise for all the methods we will use
    // @Before("execution(* * ())")
    // for one all method in one service class
    // @Before("execution(* com.iss.springaop.Service.Shape.*())") for all methods in particular class
    // 
    public void beforeAdvice()
    {
        System.out.println("Before Advice Invoked");
    }
//    @After("execution(public void callingShape()) || execution(public String getName())")
//    @After("execution(* * ())")
//    @After("execution(* com.iss.springaop.Service.Shape.*())")
    public void afterAdvice()
    {
        System.out.println("After Advice Invoked");
    }
}
