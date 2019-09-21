package com.glosys.lms.dao;

import com.glosys.lms.entity.Certificate;
import com.glosys.lms.entity.CertificateEnrolment;
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
import java.time.LocalDate;

import static org.junit.Assert.*;

public class CertificateEnrolmentDaoTest extends AbstractDaoTest{
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"student","certificate", "certificate_enrolment"};
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
        CertificateEnrolmentDao certificateEnrolmentDao = new CertificateEnrolmentDao(em);
        Certificate certificate = new CertificateHelper().save(em, LocalDate.now());
        Student student = new StudentHelper().save(em);
        CertificateEnrolment certificateEnrolment = new CertificateEnrolment(certificate, student);
        CertificateEnrolment savedCertificateEnrolment = certificateEnrolmentDao.save(certificateEnrolment);
        assertEquals(LocalDate.now(), savedCertificateEnrolment.getCertificate().getDate());
    }



}