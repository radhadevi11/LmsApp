package com.glosys.lms.dao;

import com.glosys.lms.Course;
import com.glosys.lms.CourseCategory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
            CourseDao courseDao = new CourseDao(em);
            CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
            courseDao.save(new Course("some course",
                    "15sfgh",
                    "some syllabus",
                    courseCategory,
                    true,
                    false,
                    true,
                    false));
        boolean actual = courseDao.isExistingCourse("15sfgh");
        assertEquals(true, actual);

    }


    @Test
    @Ignore
    public void testGetAllCourse(){
        CourseDao courseDao = new CourseDao(em);
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        courseDao.save(new Course("some course",
                "15sfgh",
                "some syllabus",
                courseCategory,
                true,
                false,
                true,
                false));
        int actual = courseDao.getAllCourse().size();
        System.out.println(actual);
        assertEquals(1,actual);
    }

    @Test
    public void testGetCourseByCourseId(){
        CourseDao courseDao = new CourseDao(em);
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        courseDao.save(new Course("some course",
                "15sfgh",
                "some syllabus",
                courseCategory,
                true,
                false,
                true,
                false));
        Course actual = courseDao.getCourseByCourseId(1);
        assertEquals(actual.getCode(),"15sfgh");
    }
    @Test
    @Ignore
    public void testUpdate(){
        CourseDao courseDao = new CourseDao(em);
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);

        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        Course course = new Course("some course",
                "15sfgh",
                "some syllabus",
                courseCategory,
                true,
                false,
                true,
                false);
        courseDao.save(course);

        Course updatedCourse = new Course(1,"updated course",
                "AD01",
                "some syllabus",
                courseCategory,
                true,
                false,
                true,
                true);

        courseDao.updateCourseByCourseId(updatedCourse);
        assertEquals("updated course", course.getName());
        assertEquals("AD01",course.getCode());
        assertEquals(true, course.isCorporateTrainingEligibility());

    }

}