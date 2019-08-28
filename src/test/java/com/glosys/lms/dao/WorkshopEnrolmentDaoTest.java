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
    public void testGetAvailableWorkshopForEnrolledStudent(){
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
        Workshop workshop = new Workshop(null,course, LocalDate.of(2020, Month.OCTOBER, 25));
        workshopDao.save(workshop);

        WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);
        WorkshopEnrolment workshopEnrolment = new WorkshopEnrolment(student, workshop);
        workshopEnrolmentDao.save(workshopEnrolment);
        List<Workshop> actual = workshopEnrolmentDao.getAvailableWorkshopForStudent(1);
        assertEquals(0, actual.size());

    }
    @Ignore
    @Test
    public void testGetAvailableWorkshopForNotEnrolledStudent(){
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
        Workshop workshop = new Workshop(null,course, LocalDate.of(2020, Month.OCTOBER, 25));
        workshopDao.save(workshop);
        Workshop workshop1 = new Workshop();
        workshopDao.save(workshop1);

        WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);
        WorkshopEnrolment workshopEnrolment = new WorkshopEnrolment(student, workshop1);
        WorkshopEnrolment workshopEnrolment2 = new WorkshopEnrolment(student, workshop1);
        workshopEnrolmentDao.save(workshopEnrolment);
        workshopEnrolmentDao.save(workshopEnrolment2);

        List<Workshop> actual = workshopEnrolmentDao.getAvailableWorkshopForStudent(2);
        assertEquals(2, actual.size());

    }

    @Test
    public void testGetEnrolmentsByStudentId(){
        StudentDaoImpl studentDao = new StudentDaoImpl(em);
        Student student = new Student();
        studentDao.save(student);

        Student student2 = new Student();
        studentDao.save(student2);

        System.out.println("Student id is "+student.getId());
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        CourseDao  courseDao = new CourseDao(em);
        Course course = new Course(null, null, null, courseCategory, true, true, true, true);
        courseDao.save(course);
        WorkshopDao workshopDao = new WorkshopDao(em);
        Workshop workshop = new Workshop(null,course, LocalDate.of(2020, Month.OCTOBER, 25));
        workshopDao.save(workshop);
        Workshop workshop1 = new Workshop();
        workshopDao.save(workshop1);

        WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);
        WorkshopEnrolment workshopEnrolment = new WorkshopEnrolment(student, workshop1);
        WorkshopEnrolment workshopEnrolment2 = new WorkshopEnrolment(student2, workshop1);
        workshopEnrolmentDao.save(workshopEnrolment);
        workshopEnrolmentDao.save(workshopEnrolment2);

        List<WorkshopEnrolment> actual = workshopEnrolmentDao.getEnrolmentsByStudentId(1);
        assertEquals(1,actual.size() );

        List<WorkshopEnrolment> actual2 = workshopEnrolmentDao.getEnrolmentsByStudentId(2);
        assertEquals(1,actual2.size() );

    }


}