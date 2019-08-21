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


}