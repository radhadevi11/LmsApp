package com.glosys.lms.service;

import com.glosys.lms.dao.*;
import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.TrainingProgram;
import com.glosys.lms.entity.Workshop;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TrainerServiceTest  {

    public static final int TRAINER_ID = 1;

    @InjectMocks
    @Spy
    TrainerService trainerService;

    @Mock
    WorkshopDao workshopDao;

    @Mock
    InplantTrainingDao inplantTrainingDao;

    @Test
    public void testGetTrainingPrograms(){
        LocalDate date1 = LocalDate.of(2019, 10, 25);
        LocalDate date2 = LocalDate.of(2019, 10, 26);
        LocalDate date3 = LocalDate.of(2019, 10, 27);
        LocalDate date4 = LocalDate.of(2019, 10, 28);
        Workshop workshop1 = new Workshop(null, null, date4, null, null);
        Workshop workshop2 = new Workshop(null, null, date3, null, null);


        InplantTraining inplantTraining1 = new InplantTraining(null, null, date2, null);
        InplantTraining inplantTraining2 = new InplantTraining(null, null, date1, null);


        List<Workshop> workshops = Arrays.asList(workshop1, workshop2);
        List<InplantTraining> inplantTrainings = Arrays.asList(inplantTraining1, inplantTraining2);

        doReturn(workshops).when(workshopDao).getWorkshopTrainings(TRAINER_ID);
        doReturn(inplantTrainings).when(inplantTrainingDao).getInplantTrainings(TRAINER_ID);

        List<TrainingProgram> actual =  trainerService.getTrainingPrograms(TRAINER_ID, workshopDao, inplantTrainingDao);

        verify(workshopDao).getWorkshopTrainings(TRAINER_ID);
        verify(inplantTrainingDao).getInplantTrainings(TRAINER_ID);

        Assertions.assertThat(actual).containsExactly(inplantTraining2, inplantTraining1, workshop2, workshop1);



    }

}