package com.glosys.lms.dao;

import static org.junit.Assert.*;

public class CourseDaoTest2 {
    public static void main(String[] args) {
        CourseDao courseDao = new CourseDao();
        System.out.println(courseDao.isExistingCourse("AD01"));
        System.out.println(courseDao.isExistingCourse("AD08"));
    }

}