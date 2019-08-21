package com.glosys.lms.dao;

import com.glosys.lms.entity.Student;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.Assert.*;


public class LoginDaoTest extends AbstractDaoTest {


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
    public void testGetValidUser(){
        StudentDaoImpl studentDao = new StudentDaoImpl(em);
        studentDao.save(new Student("Some",null,null,"test@gmail.com",null,"psw"));
        LoginDao loginDao = new LoginDao(em);
        Student actual = loginDao.getValidUser("test@gmail.com", "psw");
        assertEquals("Some", actual.getFirstName());
        assertNotNull(actual);
    }

    @Test
    public void testGetInvalidUser(){
        LoginDao loginDao = new LoginDao(em);
        Student actual = loginDao.getValidUser("test@gmail.com", "psw");
        assertNull(actual);
    }




}