package com.glosys.lms.dao;

import com.glosys.lms.entity.*;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.*;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

@Ignore
public class WorkshopDaoTest extends AbstractDaoTest {
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {

        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = { "course", "workshop_type","workshop"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }

    @Test
    public void testSaveWorkshop(){
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        CourseDao  courseDao = new CourseDao(em);
        Course course = new Course(null, null, null, courseCategory, true, true, true, true);
        courseDao.save(course);
        WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao(em);
        WorkshopType workshopType = new WorkshopType();
        workshopTypeDao.save(workshopType);
        Workshop workshop = new Workshop(workshopType, course, LocalDate.of(2019, 10, 25));
        WorkshopDao workshopDao = new WorkshopDao(em);
        workshopDao.save(workshop);

    }
    @Test
    public void testNotExistingWorkshop(){
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        CourseDao  courseDao = new CourseDao(em);
        Course course = new Course(null, null, null, courseCategory, true, true, true, true);
        courseDao.save(course);
        WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao(em);
        WorkshopType workshopType = new WorkshopType();
        workshopTypeDao.save(workshopType);
        Workshop workshop = new Workshop(workshopType, course, LocalDate.of(2019,Month.OCTOBER, 25));
        WorkshopDao workshopDao = new WorkshopDao(em);
        workshopDao.save(workshop);
        boolean actual = workshopDao.isExistingWorkshop(2, 2, LocalDate.of(2020, Month.MAY, 25));
        assertEquals(false, actual);

    }
    @Ignore
    @Test
    public void testExistingWorkshop(){
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        CourseDao  courseDao = new CourseDao(em);
        Course course = new Course(null, null, null, courseCategory, true, true, true, true);
        courseDao.save(course);
        WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao(em);
        WorkshopType workshopType = new WorkshopType();
        workshopTypeDao.save(workshopType);
        Workshop workshop = new Workshop(workshopType, course, LocalDate.of(2019, Month.OCTOBER, 25));
        WorkshopDao workshopDao = new WorkshopDao(em);
        workshopDao.save(workshop);
        boolean actual = workshopDao.isExistingWorkshop(1, 1, LocalDate.of(2019, Month.OCTOBER, 25));
        assertEquals(true, actual);

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
        List<Workshop> actual = workshopDao.getAvailableAndFutureWorkshopsByStudentId(1);
        assertEquals(0, actual.size());

    }

    @Test
    public void testGetAvailableWorkshopForNotEnrolledStudent(){
        StudentDaoImpl studentDao = new StudentDaoImpl(em);
        Student student = new Student();
        studentDao.save(student);
        System.out.println("id of 1st student "+student.getId());
        Student student2 = new Student();
        studentDao.save(student2);
        System.out.println("id of second student "+student2.getId());
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        CourseDao  courseDao = new CourseDao(em);
        Course course = new Course(null, null, null, courseCategory, true, true, true, true);
        courseDao.save(course);
        WorkshopDao workshopDao = new WorkshopDao(em);
        Workshop workshop = new Workshop(null,course, LocalDate.of(2019, Month.OCTOBER, 01));
        workshopDao.save(workshop);
        System.out.println("id of first workshop "+workshop.getId());
        Workshop workshop2 = new Workshop(null,course, LocalDate.of(2019, Month.JUNE, 10));
        workshopDao.save(workshop2);
        System.out.println("id of second workshop "+workshop2.getId());

        WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);
        WorkshopEnrolment workshopEnrolment = new WorkshopEnrolment(student2, workshop2);
        workshopEnrolmentDao.save(workshopEnrolment);


        List<Workshop> actual = workshopDao.getAvailableAndFutureWorkshopsByStudentId(3);
        assertEquals(1, actual.size());

    }



}