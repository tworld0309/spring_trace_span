package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("context : {}" + context);

//        ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
//        System.out.println(exampleBean.getName());
    }
}