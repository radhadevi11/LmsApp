package com.glosys.lms.dao;

import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.CourseCategory;

import javax.persistence.EntityManager;

public class CourseHelper {
    public Course save(EntityManager em){
        CourseDao  courseDao = new CourseDao(em);
        CourseCategory savedCourseCategory = new CourseCategoryHelper().save(em, "some course category");
        Course course = new Course(null, null, null, savedCourseCategory, true, true, true, true);
        return courseDao.save(course);
    }
}
