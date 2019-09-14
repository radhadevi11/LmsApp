package com.glosys.lms.dao;

import com.glosys.lms.entity.Trainer;
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
import java.util.List;

import static org.junit.Assert.*;

public class TrainerDaoTest extends AbstractDaoTest{
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"trainer", "workshop"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }

    @Test
    public void testSaveTrainer(){
        TrainerDao trainerDao = new TrainerDao(em);
        Trainer trainer = new Trainer("Radha", "Devi", "female", "C,JAVA", "Radha1234", "pass");
        Trainer savedTrainer = trainerDao.save(trainer);
        assertEquals("Radha", savedTrainer.getFirstName());
    }

    @Test
    public void testGetAvailableTrainers(){
        Trainer savedTrainer1 = new TrainerHelper().save(em, "Shubha");
        Trainer savedTrainer2 = new TrainerHelper().save(em, "Hema");
        new WorkshopHelper().save(em, LocalDate.of(2019,05,15),savedTrainer1);

        TrainerDao trainerDao = new TrainerDao(em);
        List<Trainer> availableTrainers = trainerDao.getAvailableTrainers(LocalDate.of(2019, 05, 15));
        assertEquals(1, availableTrainers.size());


    }

    @Test
    public void testGetAvailableTrainersWithPastTrainingDate(){
        Trainer savedTrainer1 = new TrainerHelper().save(em, "Shalini");
        Trainer savedTrainer2 = new TrainerHelper().save(em, "Sindhu");
        new WorkshopHelper().save(em, LocalDate.of(2018,05,15),savedTrainer1);

        TrainerDao trainerDao = new TrainerDao(em);
        List<Trainer> availableTrainers = trainerDao.getAvailableTrainers(LocalDate.of(2019, 05, 15));

        assertEquals(2, availableTrainers.size());


    }

    @Test
    public void testGetAllTrainers(){
        Trainer savedTrainer1 = new TrainerHelper().save(em, "Radha");
        Trainer savedTrainer2 = new TrainerHelper().save(em, "vishnu");

        TrainerDao trainerDao = new TrainerDao(em);
        List<Trainer> actual = trainerDao.getAllTrainers();

        assertEquals(2, actual.size());

    }



}