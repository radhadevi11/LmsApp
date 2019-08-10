package com.glosys.lms.dao;

import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.CourseCategory;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;


public class CourseDaoTest {
    protected static EntityManagerFactory emf;
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        emf = Persistence.createEntityManagerFactory("lms-app-test");
        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"course_category", "course"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }


    @Test
    public void testSave(){
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
        boolean actual = courseDao.isExistingCourse("15sfgh");
        assertEquals(true, actual);


    }


    @Test

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
        List<Course> allCourse = courseDao.getAllCourse();
        int actual = allCourse.size();
        System.out.println("All courses "+ allCourse);
        System.out.println(actual);
        assertEquals(1,actual);
    }

    @Test
    public void testGetCourseByCourseId(){
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

        Course actual = courseDao.getCourseByCourseId(course.getId());
        assertEquals(actual.getCode(),"15sfgh");
    }
    @Test

    public void testUpdate(){
        CourseDao courseDao = new CourseDao(em);
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);

        CourseCategory courseCategory = new CourseCategory("some course category");
        Course course = getCourse(courseDao, courseCategoryDao, courseCategory);

        Course updatedCourse = new Course(course.getId(),"updated course",
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

    private Course getCourse(CourseDao courseDao, CourseCategoryDao courseCategoryDao, CourseCategory courseCategory) {
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
        System.out.println("new course id is "+course.getId());
        return course;
    }

   // public void test

}