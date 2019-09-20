package com.glosys.lms.service;

import com.glosys.lms.dao.*;
import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.Trainer;
import com.glosys.lms.entity.TrainingProgram;
import com.glosys.lms.entity.Workshop;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TrainerServiceTest extends AbstractDaoTest {

    public static final int TRAINER_ID = 1;

    @InjectMocks
    @Spy
    TrainerService trainerService;

    @Mock
    WorkshopDao workshopDao;

    @Mock
    InplantTrainingDao inplantTrainingDao;

    protected static EntityManager em ;
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        em = emf.createEntityManager();

    }
    @Before
    public  void setUp() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.h2.Driver", "jdbc:h2:mem:test");
        String[] tables = {"inplant_training_type","course","trainer", "inplant_training","workshop_type", "workshop"};
        IDataSet dataSet = databaseTester.getConnection().createDataSet(tables);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

    }

    @After
    public void after(){
        em.clear();
    }

    @Test
    public void mockTestGetTrainingPrograms(){
        List<TrainingProgram> trainingPrograms = mock(List.class);
        List<Workshop> workshops = workshopDao.getWorkshopTrainings(TRAINER_ID);
        List<InplantTraining> inplantTrainings = inplantTrainingDao.getInplantTrainings(TRAINER_ID);
        doReturn(true).when(trainingPrograms).addAll(workshops);
        doReturn(true).when(trainingPrograms).addAll(inplantTrainings);

        List<TrainingProgram> actual =  trainerService.getTrainingPrograms(TRAINER_ID);

        verify(workshopDao).getWorkshopTrainings(TRAINER_ID);
        verify(inplantTrainingDao).getInplantTrainings(TRAINER_ID);
        verify(trainingPrograms).addAll(workshops);
        verify(trainingPrograms).addAll(inplantTrainings);




    }


    @Test
    public void testGetTrainingPrograms()  {

        LocalDate currentDate = LocalDate.now();
        Trainer trainer = new TrainerHelper().save(em, "Radha");
        Trainer trainer2 = new TrainerHelper().save(em, "Vishnu");

        InplantTraining inplantTraining = new InplantTrainingHelper().save(em,currentDate.plusDays(5),trainer);
        InplantTraining inplantTraining2 = new InplantTrainingHelper().save(em,currentDate, trainer);
        InplantTraining inplantTraining3 = new InplantTrainingHelper().save(em,currentDate.minusDays(5), trainer);
        InplantTraining inplantTraining4 = new InplantTrainingHelper().save(em,currentDate.plusDays(5), trainer2);
         InplantTrainingDao inplantTrainingDao = new InplantTrainingDao(em);


        Workshop workshop = new WorkshopHelper().save(em,currentDate.plusDays(10), trainer2);
        Workshop workshop2 = new WorkshopHelper().save(em,currentDate.plusDays(10), trainer);
        Workshop workshop3 = new WorkshopHelper().save(em,currentDate.minusDays(15),trainer);
        Workshop workshop4 = new WorkshopHelper().save(em,currentDate.plusDays(10), trainer2);



        TrainerService trainerService = new TrainerService();
        List<TrainingProgram> actual = trainerService.getTrainingPrograms(trainer.getId(),new WorkshopDao(em),
                new InplantTrainingDao(em));

        assertEquals(3,actual.size() );
        assertEquals(actual.get(1).getStartDate(), currentDate.plusDays(5) );


    }
}