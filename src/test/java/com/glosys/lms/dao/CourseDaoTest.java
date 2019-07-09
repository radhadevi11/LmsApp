/*package com.glosys.lms.dao;

import com.glosys.lms.Course;
import com.glosys.lms.CourseCategory;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class CourseDaoTest {
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        emf = Persistence.createEntityManagerFactory("lms-app-test");
        em = emf.createEntityManager();
    }

    public static void main(String[] args) {
        CourseDao courseDao = new CourseDao();
        List<Course> coursesForWorkshop = courseDao.getCoursesForWorkshop();
        System.out.println("getting course category");
        System.out.println(coursesForWorkshop.get(1).getCourseCategory());
        courseDao.save(new Course("some course",
                "15sfg",
                "some syllabus",
                new CourseCategory(6),
                true,
               false,
                true,
                false));
        //System.out.println(courseDao.getCoursesForInplantTraining());
       // System.out.println(courseDao.getCoursesForCorporateTraining());

    }

    @Test
    public void testSave(){





    }

}*/