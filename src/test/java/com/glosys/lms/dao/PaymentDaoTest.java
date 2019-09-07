package com.glosys.lms.dao;

import com.glosys.lms.entity.Payment;
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

public class PaymentDaoTest extends AbstractDaoTest {
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {

        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"payment"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }
    @Test
    public void testSavePayment(){
        PaymentDao paymentDao = new PaymentDao(em);
        Payment payment = new Payment("Radha", "VISA", "123456789456123", "123", LocalDate.of(2020, 05, 30));
        Payment actual = paymentDao.save(payment);
        assertEquals("Radha", actual.getCardHolderName());
    }

}