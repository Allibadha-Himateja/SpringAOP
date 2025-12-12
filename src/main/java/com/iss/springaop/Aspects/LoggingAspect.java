package com.iss.springaop.Aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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
    // we have a provision where we can manage the advice for the method with different names
    // @Before("execution(* set*()") || Product.set*()
    // this code will apply the advice for all the methods which starts with set as the function name

    // there is a possiblity of having a method with parameters so assuming the setName(String name) as the parameter
    // we will be using the advices as
    // @Before("execution( * setName(..))") here ".." is for specifying the method parameters


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


    // we have more advices which are
    // @Around
    // @AfterReturing
    // @AfterThrowing


    @Around("execution(* com.iss.springaop.Models.*.setName(..))")
    public  Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("before setName Invoked");
        Object o= pjp.proceed();
        System.out.println(o);
        // what we have returned from the method that will be caught here
        // from the application we have called the setName("MyCircle") for circle bean
        // the circle bean created and the around aspect calls the setName()  method with object o
        // before setName Invoked
        // MyCircle
        // after setName Invoked
        System.out.println("after setName Invoked");
        return o;
    }

}
