package com.glosys.lms.dao;

import com.glosys.lms.entity.ResearchTrainingType;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.*;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;


public class ResearchTrainingTypeDaoTest extends AbstractDaoTest {

    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {

        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"research_training",
                "training_program_type"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }

    @Test
    public void testGetResearchTrainings(){
        ResearchTrainingDao researchTrainingDao = new ResearchTrainingDao(em);
        researchTrainingDao.save(new ResearchTrainingType());
        List<ResearchTrainingType> actual = researchTrainingDao.getResearchTrainings();
        assertEquals(1, actual.size());

    }


}