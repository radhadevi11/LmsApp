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
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
        String[] tables = {"student", "workshop", "workshop_enrolment"};
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

    @Test
    public void testGetEnrolmentsByStudentId(){
        StudentDaoImpl studentDao = new StudentDaoImpl(em);
        Student student = new Student();
        student.setFirstName("radha");

        Student savedStudent = studentDao.save(student);


        System.out.println("Student id is "+savedStudent.getId());
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        CourseCategory savedCourseCategory = courseCategoryDao.save(courseCategory);
        CourseDao  courseDao = new CourseDao(em);
        Course course = new Course("some course", null, null, new CourseCategory(savedCourseCategory.getId()), true, true, true, true);
        Course savedCourse = courseDao.save(course);
        WorkshopDao workshopDao = new WorkshopDao(em);
        LocalDate date = LocalDate.of(2020, Month.OCTOBER, 25);
        Workshop workshop = new Workshop(null,new Course(savedCourse.getId()), date);
        Workshop savedWorkshop = workshopDao.save(workshop);


        WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);
        WorkshopEnrolment workshopEnrolment = new WorkshopEnrolment(new Student(savedStudent.getId())
                ,new Workshop(savedWorkshop.getId()));

        WorkshopEnrolment savedEnrolment = workshopEnrolmentDao.save(workshopEnrolment);

        List<WorkshopEnrolment> actual = workshopEnrolmentDao.getEnrolmentsByStudentId(savedStudent.getId());
        assertEquals(1,actual.size() );
        assertEquals(date, actual.get(0).getWorkshop().getDate());


    }


}