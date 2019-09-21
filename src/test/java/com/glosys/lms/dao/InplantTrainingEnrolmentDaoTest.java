package com.glosys.lms.dao;

import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.InplantTrainingEnrolment;
import com.glosys.lms.entity.Student;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class InplantTrainingEnrolmentDaoTest extends AbstractDaoTest{
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"student", "inplant_training", "inplant_training_enrolment"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }

    @Test
    public void testSave(){
        InplantTrainingEnrolmentDao inplantTrainingEnrolmentDao = new InplantTrainingEnrolmentDao(em);
        Student student = new StudentHelper().save(em);
        InplantTraining inplantTraining = new InplantTrainingHelper().save(em, LocalDate.now());
        InplantTrainingEnrolment actual = inplantTrainingEnrolmentDao.save(
                new InplantTrainingEnrolment(student, inplantTraining));
        actual.getStudent().setFirstName("Radha");
        assertEquals("Radha", actual.getStudent().getFirstName() );
    }


}