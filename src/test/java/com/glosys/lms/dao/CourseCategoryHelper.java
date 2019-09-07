package com.glosys.lms.dao;

import com.glosys.lms.entity.CourseCategory;

import javax.persistence.EntityManager;

public class CourseCategoryHelper {
    public CourseCategory save(EntityManager em, String name) {
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory(name);
        return courseCategoryDao.save(courseCategory);
    }

}
