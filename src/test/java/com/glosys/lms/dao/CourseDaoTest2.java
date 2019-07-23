package com.glosys.lms.dao;

import com.glosys.lms.Course;
import com.glosys.lms.CourseCategory;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseDaoTest2 {

    @Test
    public void testUpdate(){
        CourseDao courseDao = new CourseDao();
        CourseCategory courseCategory = new CourseCategory(5);
        Course t = new Course(16,"updated course",
                "AD01",
                "some syllabus",
                courseCategory,
                true,
                false,
                true,
                true);
        Course course = new Course(16,"some course",
                "15sfgh",
                "some syllabus",
                courseCategory,
                true,
                false,
                true,
                false);
        Course c = courseDao.updateCourseByCourseId(course);
        System.out.println(c.getCode());


    }

    @Test
    public void testDelete(){
        CourseDao courseDao = new CourseDao();
        courseDao.deleteCourse(28);



    }

}