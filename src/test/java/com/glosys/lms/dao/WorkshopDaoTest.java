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

        Course course1 = new CourseHelper().save(em);
        WorkshopType workshopType1 = new WorkshopTypeHelper().save(em);

        Workshop workshop = new Workshop(workshopType1, course1, LocalDate.of(2019, 10, 25));
        WorkshopDao workshopDao = new WorkshopDao(em);
        workshopDao.save(workshop);


    }
    @Test
    public void testNotExistingWorkshop(){

        WorkshopDao workshopDao = new WorkshopDao(em);

        Workshop workshop1 = new WorkshopHelper().save(em, LocalDate.of(2019, Month.OCTOBER, 25));
        boolean actual = workshopDao.isExistingWorkshop(workshop1.getWorkshopType().getId(),
               workshop1.getCourse().getId(),
                LocalDate.of(2020, Month.MAY, 25));

        assertEquals(false, actual);

    }
    @Test
    public void testExistingWorkshop(){


        WorkshopDao workshopDao = new WorkshopDao(em);

        Workshop workshop1 = new WorkshopHelper().save(em, LocalDate.of(2020, Month.MAY, 25));
        boolean actual = workshopDao.isExistingWorkshop(workshop1.getWorkshopType().getId(),
                workshop1.getCourse().getId(),
                LocalDate.of(2020, Month.MAY, 25));

        assertEquals(true, actual);

    }

    @Test
    public void testGetAvailableWorkshopForEnrolledStudent(){
        StudentDaoImpl studentDao = new StudentDaoImpl(em);
        Student savedStudent = studentDao.save(new Student());

        WorkshopDao workshopDao = new WorkshopDao(em);


        Workshop workshop = new WorkshopHelper().save(em, LocalDate.of(2020, Month.OCTOBER, 25));

        WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);
        WorkshopEnrolment workshopEnrolment = new WorkshopEnrolment(savedStudent, workshop);
        workshopEnrolmentDao.save(workshopEnrolment);
        List<Workshop> actual = workshopDao.getAvailableAndFutureWorkshopsByStudentId(savedStudent.getId());
        assertEquals(0, actual.size());

    }

    @Test
    public void testGetAvailableWorkshopReturnsOnlyFutureWorkshops(){
        Student student = new StudentHelper().save(em);
        WorkshopDao workshopDao = new WorkshopDao(em);
        LocalDate currentDate = LocalDate.now();
        Workshop futureWorkshop = new WorkshopHelper().save(em, currentDate.plusDays(5));
        Workshop pastWorkshop =  new WorkshopHelper().save(em, currentDate.minusDays(5));

        List<Workshop> actual = workshopDao.getAvailableAndFutureWorkshopsByStudentId(student.getId());

        assertEquals(1, actual.size());
        assertEquals(futureWorkshop.getId(), actual.get(0).getId());

    }



}