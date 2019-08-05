package com.glosys.lms.dao;

import com.glosys.lms.entity.ResearchTraining;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

@Ignore
public class ResearchTrainingDaoTest {
    protected static EntityManagerFactory emf;
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        emf = Persistence.createEntityManagerFactory("lms-app-test");
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
        List<ResearchTraining> actual = researchTrainingDao.getResearchTrainings();
        assertEquals(0, actual.size());

    }


}