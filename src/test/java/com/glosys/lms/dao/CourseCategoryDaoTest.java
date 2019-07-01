package com.glosys.lms.dao;

import com.glosys.lms.CourseCategory;

import java.util.List;

import static org.junit.Assert.*;

public class CourseCategoryDaoTest {
    public static void main(String[] args) {
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao();
        List<CourseCategory> courseCategories = courseCategoryDao.getCourseCategories();
        System.out.println(courseCategories);
    }

}