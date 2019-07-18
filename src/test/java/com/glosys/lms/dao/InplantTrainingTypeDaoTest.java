package com.glosys.lms.dao;

import com.glosys.lms.Course;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InplantTrainingTypeDaoTest {
    public static void main(String[] args) {
        InplantTrainingTypeDao inplantTrainingTypeDao = new InplantTrainingTypeDao();
        System.out.println(inplantTrainingTypeDao.getInplantTrainingTypes());
    }

    @Test
    public void testGetCoursesForResearchTraining(){
        CourseDao courseDao = new CourseDao();
        List<Course> courseList = courseDao.getCoursesForResearchTraining();
        assertEquals(1, courseList.size());

    }

}