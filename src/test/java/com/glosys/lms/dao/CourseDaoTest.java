package com.glosys.lms.dao;

import com.glosys.lms.Course;

import java.util.List;

import static org.junit.Assert.*;

public class CourseDaoTest {
    public static void main(String[] args) {
        CourseDao courseDao = new CourseDao();
       // System.out.println(courseDao.getCoursesForWorkshop());
        //System.out.println(courseDao.getCoursesForInplantTraining());
        System.out.println(courseDao.getCoursesForCorporateTraining());
    }

}