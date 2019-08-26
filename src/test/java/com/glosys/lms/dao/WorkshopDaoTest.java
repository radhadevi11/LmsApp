package com.glosys.lms.dao;

import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.CourseCategory;
import com.glosys.lms.entity.Workshop;
import com.glosys.lms.entity.WorkshopType;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

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
       // assertEquals(true, actual);

    }

    @Test
    public void testFutureWorkshop(){
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

        Workshop workshop2 = new Workshop(workshopType, course, LocalDate.of(2019, Month.APRIL, 25));
        workshopDao.save(workshop2);

        Workshop workshop3 = new Workshop(workshopType, course, LocalDate.of(2019, Month.DECEMBER, 25));
        workshopDao.save(workshop3);

        List<Workshop> futureWorkshops = workshopDao.getFutureWorkshops();
        assertEquals(2,futureWorkshops.size());

    }
    @Test
    public void testFutureWorkshopForPastDate(){
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("some course category");
        courseCategoryDao.save(courseCategory);
        CourseDao  courseDao = new CourseDao(em);
        Course course = new Course(null, null, null, courseCategory, true, true, true, true);
        courseDao.save(course);
        WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao(em);
        WorkshopType workshopType = new WorkshopType();
        workshopTypeDao.save(workshopType);
        Workshop workshop = new Workshop(workshopType, course, LocalDate.of(2019, Month.APRIL, 25));
        WorkshopDao workshopDao = new WorkshopDao(em);
        workshopDao.save(workshop);
        List<Workshop> futureWorkshops = workshopDao.getFutureWorkshops();
        assertEquals(0,futureWorkshops.size());

    }


}