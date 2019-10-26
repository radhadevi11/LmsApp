package com.glosys.lms.dao;

import com.glosys.lms.entity.Student;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class StudentDaoImplTest extends AbstractDaoTest{
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"student"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }


    @Test
    public void testExistingMailId(){
        Student student = new StudentHelper().save(em);
        student.setMailId("abc@gmail.com");

        StudentDaoImpl studentDao = new StudentDaoImpl(em);
        boolean actual = studentDao.isExistingMailId(student.getMailId());
        assertEquals(true, actual);
    }

    @Test
    public void testNotExistingMailId(){
        Student student = new StudentHelper().save(em);
        student.setMailId("abc@gmail.com");

        StudentDaoImpl studentDao = new StudentDaoImpl(em);
        boolean actual = studentDao.isExistingMailId("some@gmail.com");
        assertEquals(false, actual);
    }



}