package com.glosys.lms.dao;

import com.glosys.lms.ResearchTraining;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

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
    protected static EntityManager em;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        emf = Persistence.createEntityManagerFactory("lms-app-test");
        em = emf.createEntityManager();
    }

    @Test
    public void testGetResearchTrainings(){
        ResearchTrainingDao researchTrainingDao = new ResearchTrainingDao(em);
        List<ResearchTraining> actual = researchTrainingDao.getResearchTrainings();
        assertEquals(0, actual.size());
    }


}