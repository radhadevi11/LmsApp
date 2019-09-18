package com.glosys.lms.dao;

import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.InplantTrainingType;
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

public class InplantTrainingTypeDaoTest extends AbstractDaoTest {
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"inplantTrainingType"};
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
        InplantTrainingTypeDao inplantTrainingTypeDao = new InplantTrainingTypeDao(em);
        InplantTrainingType actual = inplantTrainingTypeDao.save(new InplantTrainingType
                ("class room", 25, 20, 20, 20, "overview", 0));
        assertEquals("class room", actual.getModeOfTraining());
    }


}