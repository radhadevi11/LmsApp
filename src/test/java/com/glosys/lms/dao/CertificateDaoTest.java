package com.glosys.lms.dao;

import com.glosys.lms.entity.Certificate;
import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.Trainer;
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

public class CertificateDaoTest extends AbstractDaoTest{
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"trainer", "course", "certificate"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }


    @Test
    public void saveCertificate(){
        Course course = new CourseHelper().save(em);
        Trainer trainer = new TrainerHelper().save(em, "Radha");
        Certificate certificate = new Certificate("certificate1", course, LocalDate.now(), trainer);
        CertificateDao certificateDao = new CertificateDao(em);
        Certificate savedCertificate = certificateDao.save(certificate);
        assertEquals("certificate1", savedCertificate.getName());

    }


}