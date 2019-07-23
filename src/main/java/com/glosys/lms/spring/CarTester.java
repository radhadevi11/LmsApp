package com.glosys.lms.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarTester {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.glosys.lms");
        Car car = context.getBean(Car.class);
        CourseDao2 courseDao2 = context.getBean(CourseDao2.class);
        System.out.println(car.getEngine().getEngineType());
    }

}
