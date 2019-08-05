package com.glosys.lms.dao;

import com.glosys.lms.entity.Course;
import org.junit.Test;

import java.util.List;

public class InplantTrainingTypeDaoTest {
    public static void main(String[] args) {
        InplantTrainingTypeDao inplantTrainingTypeDao = new InplantTrainingTypeDao();
        System.out.println(inplantTrainingTypeDao.getInplantTrainingTypes());
    }

    @Test
    public void testGetCoursesForResearchTraining(){
        CourseDao courseDao = new CourseDao();
        List<Course> courseList = courseDao.getCoursesForResearchTraining();



    }

}