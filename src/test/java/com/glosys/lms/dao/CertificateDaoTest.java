package com.glosys.lms.dao;

import com.glosys.lms.entity.*;
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
import java.util.List;

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

    @Test
    public void testGetSearchResultsFromCertificate(){
        Certificate certificate = new CertificateHelper().save(em, LocalDate.now());
        Student student = new StudentHelper().save(em);
        certificate.getCourse().setName("Web application development using python");

        CertificateDao certificateDao = new CertificateDao(em);
        List<Certificate> actual = certificateDao.getSearchResultsFromCertificate("python", student.getId());

        assertEquals(1, actual.size() );
    }

    @Test
    public void testGetSearchResultsFromCertificateForCaseInsensitive(){
        Certificate certificate = new CertificateHelper().save(em, LocalDate.now());
        Student student = new StudentHelper().save(em);
        certificate.getCourse().setName("Web application development using python");

        CertificateDao certificateDao = new CertificateDao(em);
        List<Certificate> actual = certificateDao.getSearchResultsFromCertificate("PYTHON", student.getId());

        assertEquals(1, actual.size() );
    }

    @Test
    public void testGetSearchResultsFromCertificateForEnrolledStuent(){
        Certificate certificate = new CertificateHelper().save(em, LocalDate.now());
        Student student = new StudentHelper().save(em);
        certificate.getCourse().setName("Web application development using python");
        CertificateEnrolment certificateEnrolment = new CertificateEnrolmentHelper().save(em);
        certificateEnrolment.setStudent(student);
        certificateEnrolment.setCertificate(certificate);

        CertificateDao certificateDao = new CertificateDao(em);
        List<Certificate> actual = certificateDao.getSearchResultsFromCertificate("python", student.getId());

        assertEquals(0, actual.size() );
    }

    @Test
    public void testGetSearchResultsFromCertificateForPastCertificate(){
        Certificate certificate = new CertificateHelper().save(em, LocalDate.now().minusDays(5));
        Student student = new StudentHelper().save(em);
        certificate.getCourse().setName("Web application development using python");

        CertificateDao certificateDao = new CertificateDao(em);
        List<Certificate> actual = certificateDao.getSearchResultsFromCertificate("python", student.getId());

        assertEquals(0, actual.size() );
    }

    @Test
    public void getCertificateByCourseCategory(){
        CourseCategoryDao courseCategoryDao = new CourseCategoryDao(em);
        CourseCategory courseCategory = new CourseCategory("psp");
        CourseCategory courseCategory1 = courseCategoryDao.save(courseCategory);


        Course course = new Course("JAVA", "","", courseCategory1, true,true,true,true);
        CourseDao courseDao = new CourseDao(em);
        Course course1 = courseDao.save(course);

        Certificate certificate = new Certificate("GCPSP", course1, null, null);

        CertificateDao certificateDao = new CertificateDao(em);
        Certificate certificate1 = certificateDao.save(certificate);

        List<Certificate> actual = certificateDao.getCertificatesByCourseCategoryId(courseCategory1.getId());

        assertEquals(1, actual.size());

    }


}