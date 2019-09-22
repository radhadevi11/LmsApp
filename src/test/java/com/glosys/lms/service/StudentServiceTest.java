package com.glosys.lms.service;

import com.glosys.lms.dao.CertificateDao;
import com.glosys.lms.dao.InplantTrainingDao;
import com.glosys.lms.dao.WorkshopDao;
import com.glosys.lms.entity.Certificate;
import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.TrainingProgram;
import com.glosys.lms.entity.Workshop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
    @InjectMocks
    @Spy
    StudentService studentService;

    @Mock
    WorkshopDao workshopDao;

    @Mock
    InplantTrainingDao inplantTrainingDao;

    @Mock
    CertificateDao certificateDao;

    private static final String COURSE_NAME = " Python";
    private static final String TRIMMED_COURSE_NAME = "Python";
    private static final int STUDENT_ID = 1;

    @Test
    public void getSearchResults() {
        LocalDate date1 = LocalDate.of(2019, 10, 25);
        LocalDate date2 = LocalDate.of(2019, 10, 26);
        LocalDate date3 = LocalDate.of(2019, 10, 27);
        LocalDate date4 = LocalDate.of(2019, 10, 28);
        LocalDate date5 = LocalDate.of(2019, 10, 29);
        LocalDate date6 = LocalDate.of(2019, 10, 30);

        Workshop workshop1 = new Workshop(null, null, date4, null, null);
        Workshop workshop2 = new Workshop(null, null, date3, null, null);

        InplantTraining inplantTraining1 = new InplantTraining(null, null, date2, null);
        InplantTraining inplantTraining2 = new InplantTraining(null, null, date1, null);

        Certificate certificate1 = new Certificate(null, null, date5, null);
        Certificate certificate2 = new Certificate(null, null, date6, null);

        List<Workshop> workshops = Arrays.asList(workshop1, workshop2);
        List<InplantTraining> inplantTrainings = Arrays.asList(inplantTraining1, inplantTraining2);
        List<Certificate> certificates = Arrays.asList(certificate1, certificate2);

        doReturn(workshops).when(workshopDao).getSearchResultsFromWorkshop(TRIMMED_COURSE_NAME, STUDENT_ID);
        doReturn(inplantTrainings).when(inplantTrainingDao).getSearchResultsFromInplantTraining(TRIMMED_COURSE_NAME, STUDENT_ID);
        doReturn(certificates).when(certificateDao).getSearchResultsFromCertificate(TRIMMED_COURSE_NAME, STUDENT_ID);

        List<TrainingProgram> actual = studentService.getSearchResults(COURSE_NAME, STUDENT_ID, workshopDao,
                inplantTrainingDao, certificateDao);

        verify(workshopDao).getSearchResultsFromWorkshop(TRIMMED_COURSE_NAME, STUDENT_ID);
        verify(inplantTrainingDao).getSearchResultsFromInplantTraining(TRIMMED_COURSE_NAME, STUDENT_ID);
        verify(certificateDao).getSearchResultsFromCertificate(TRIMMED_COURSE_NAME, STUDENT_ID);



        assertThat(actual).containsExactly(inplantTraining2, inplantTraining1, workshop2, workshop1,
                certificate1, certificate2);


    }
}