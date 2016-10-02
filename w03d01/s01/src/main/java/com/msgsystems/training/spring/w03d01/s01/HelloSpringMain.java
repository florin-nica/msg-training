package com.msgsystems.training.spring.w03d01.s01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demonstrates a simple bean retrieving from Spring's {@link ApplicationContext}
 */
public class HelloSpringMain {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final HelloSpring helloSpring = applicationContext.getBean(HelloSpring.class);
        System.out.println(helloSpring.getWelcomeMessage());
    }
}
