package com.tit.firstprojectspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FirstProjectSpringBootApplication {

    public static void main(String[] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");

        Alien obj1 = (Alien)factory.getBean("alien");
        obj1.code();

        System.out.println(obj1.getAge());
    }

}
