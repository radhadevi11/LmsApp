package com.glosys.lms.dao;

import com.glosys.lms.entity.*;
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

public class InplantTrainingDaoTest extends AbstractDaoTest{
    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"inplant_training_type","course","trainer", "inplant_training"};
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
        InplantTrainingDao inplantTrainingDao = new InplantTrainingDao(em);
        InplantTrainingType inplantTrainingType = new InplantTrainingTypeHelper().save(em);
        Course course = new CourseHelper().save(em);
        Trainer trainer = new TrainerHelper().save(em, "some");
        LocalDate localDate = LocalDate.now();
        InplantTraining actual = inplantTrainingDao.save(new InplantTraining(inplantTrainingType, course, localDate, trainer));
        assertEquals("some", actual.getTrainer().getFirstName());

    }
    
    @Test
    public void testGetInplantTrainings(){
        LocalDate currentDate = LocalDate.now();
        Trainer trainer = new TrainerHelper().save(em, "Radha");
        Trainer trainer2 = new TrainerHelper().save(em, "Vishnu");
        InplantTraining inplantTraining = new InplantTrainingHelper().save(em,currentDate.plusDays(5),trainer);
        InplantTraining inplantTraining2 = new InplantTrainingHelper().save(em,currentDate.plusDays(5), trainer);
        InplantTraining inplantTraining3 = new InplantTrainingHelper().save(em,currentDate.minusDays(5), trainer);
        InplantTraining inplantTraining4 = new InplantTrainingHelper().save(em,currentDate.plusDays(5), trainer2);

        InplantTrainingDao inplantTrainingDao = new InplantTrainingDao(em);
        List<InplantTraining> actual = inplantTrainingDao.getInplantTrainings(trainer.getId());
        assertEquals(2, actual.size());

    }

    @Test
    public void testGetSearchResultsFromInplantTraining(){
        InplantTrainingDao inplantTrainingDao = new InplantTrainingDao(em);
        Student student = new StudentHelper().save(em);
        InplantTraining inplantTraining = new InplantTrainingHelper().save(em, LocalDate.now());
        inplantTraining.getCourse().setName("Web application development using python");

        List<InplantTraining> actual = inplantTrainingDao.getSearchResultsFromInplantTraining("python", student.getId());

        assertEquals(actual.size(), 1);
    }
}