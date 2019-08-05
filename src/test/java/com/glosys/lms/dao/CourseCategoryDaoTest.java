package com.glosys.lms.dao;

import com.glosys.lms.entity.CourseCategory;

import java.util.List;

public class CourseCategoryDaoTest {
    public static void main(String[] args) {
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao();
        List<CourseCategory> courseCategories = courseCategoryDao.getCourseCategories();
        System.out.println(courseCategories);
    }

}