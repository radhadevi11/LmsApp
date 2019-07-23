package com.glosys.lms.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourseControllerTester {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.radha.lms");
        CourseController2 courseController2 = applicationContext.getBean(CourseController2.class);
        System.out.println(courseController2.isExistingCourse("1234"));
    }
}
