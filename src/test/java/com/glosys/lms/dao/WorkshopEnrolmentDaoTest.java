package com.glosys.lms.dao;

import com.glosys.lms.entity.*;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.*;

import javax.persistence.EntityManager;
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

        Student savedStudent = new StudentHelper().save(em);

        WorkshopDao workshopDao = new WorkshopDao(em);
        Workshop workshop = new Workshop();
        Workshop savedWorkshop = workshopDao.save(workshop);

        WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);
        WorkshopEnrolment workshopEnrolment = new WorkshopEnrolment(savedStudent, savedWorkshop);
        WorkshopEnrolment savedEnrolment = workshopEnrolmentDao.save(workshopEnrolment);
        assertEquals(savedStudent, savedEnrolment.getStudent());


    }

    @Test
    public void testGetEnrolmentsByStudentId(){
        LocalDate date = LocalDate.of(2020, Month.OCTOBER, 25);
        WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);

        WorkshopEnrolment savedEnrolment = new WorkshopEnrolmentHelper().save(em,date);

        List<WorkshopEnrolment> actual = workshopEnrolmentDao.getEnrolmentsByStudentId(savedEnrolment.getStudent().getId());
        assertEquals(1,actual.size() );
        assertEquals(date, actual.get(0).getWorkshop().getDate());


    }


}