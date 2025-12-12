package com.iss.springaop;

import com.iss.springaop.Models.Circle;
import com.iss.springaop.Service.Shape;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectApplication {
    public static void main(String args[])
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("AOPConfig.xml");
        context.registerShutdownHook();

        Circle circle = context.getBean(Circle.class);
        circle.setName("MyCircle");

        Shape shape=context.getBean("shape",Shape.class);
//        shape.callingShape();
//        System.out.println(shape.getCircle().getName());
        // result for this is
        // when we use this aspect in other way which is
        // System.out.print(shape.getCircle().getName());
        // with aspect configured with the getName Method we get the results as
        // Before Advice Invoked
        // callingShape
        // After Advice Invoked
        // Before Advice Invoked
        // After Advice Invoked
        // Circle -> this is because we are calling the println after calling and returing the string
        // so the getName is running in between
        // Before Advice Invoked
        // callingShape
        // After Advice Invoked
        // Before Advice Invoked
        // returning name
        // After Advice Invoked
        // Circle

        //AOP is Aspect oriented programming which is used for making the function calls without actually calling them yourself
        // manually which is done with the help of the AOP
        // the way which we setup a project as aop is that we have to make sure we add the namespace for the beans.xml correct
        // and second thing is we have to make sure we added the
        // jars like aspectjweaver,and also the springframework.context.scheme.aop


        // that is the actual example of using the aop application
        // assuming that we are having the Models say Triangle and Circle
        // and also we are having the Service class called the Shape
        // this service class holds getCircle and getTriangle methods

        // here what we are doing is we have to create the Service class(Shape) bean  and we have to use that
        // bean to call the service methods like getCircle or getTriangle
        // for that we have to create beans inside the beans.xml for Shape,Triangle,Circle

        // and here comes the concept of Aspects in AOP
        // we are having different applications like Logging,Authentication and Authorization
        // where we have to make some operations before Some Actions

        // Here we are creating a Logging Aspect with @Aspect annotation
        // which contains two functions which are beforeAdvice() and afterAdvice()
        // this way of implementing the function will be used VIA
        // @Before and @After Annotations
        // @Before("execution(public String getName())") for the beforeAdvice() function
        // @After("execution(public String getName())") for the afterAdvice() function

        // inside the main program when we are calling the Service method getTriangle().getName()
        // here we are calling the loggingAspect @Before and @After function which are assigned to the aspect with function declaration

    }
}
