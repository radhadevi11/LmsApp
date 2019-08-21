package com.glosys.lms.dao;

import com.glosys.lms.entity.*;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.Assert.*;


public class WorkshopEnrolmentDaoTest extends AbstractDaoTest {

    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {

        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"student", "course", "workshop_type", "workshop_enrolment","workshop"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }
    @Test
    public void testSaveWorkshopEnrolment(){

        StudentDaoImpl studentDao = new StudentDaoImpl(em);
        Student student = new Student();
        studentDao.save(student);
        System.out.println("Student id is "+student.getId());
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        CourseDao  courseDao = new CourseDao(em);
        Course course = new Course(null, null, null, courseCategory, true, true, true, true);
        courseDao.save(course);
        WorkshopDao workshopDao = new WorkshopDao(em);
        Workshop workshop = new Workshop();
        workshopDao.save(workshop);

        WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);
        WorkshopEnrolment workshopEnrolment = new WorkshopEnrolment(student, workshop);
        workshopEnrolmentDao.save(workshopEnrolment);


    }

}