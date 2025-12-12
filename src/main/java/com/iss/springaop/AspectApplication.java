package com.iss.springaop;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectApplication {
    public static void main(String args[])
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("AOPConfig.xml");
        context.registerShutdownHook();


    }
}
