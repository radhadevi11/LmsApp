package com.glosys.lms.service;

import com.glosys.lms.dao.CertificateDao;
import com.glosys.lms.dao.InplantTrainingDao;
import com.glosys.lms.dao.WorkshopDao;
import com.glosys.lms.entity.*;
import com.glosys.lms.dao.DaoFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    public void saveStudent(Student student){
        DaoFactory.getStudentDao().save(student);
    }

    public List<TrainingProgram> getSearchResults(String courseName, int studentId){
        return getSearchResults(courseName, studentId, DaoFactory.getWorkshopDao(), DaoFactory.getInplantTrainingDao(),
                DaoFactory.getCertificateDao());
    }

    List<TrainingProgram> getSearchResults(String courseName, int studentId, WorkshopDao workshopDao,
                                           InplantTrainingDao inplantTrainingDao, CertificateDao certificateDao) {
        String trimCourseName = courseName.trim();
        List<Workshop> workshops = workshopDao.getSearchResultsFromWorkshop(trimCourseName, studentId);
        List<InplantTraining> inplantTrainings = inplantTrainingDao.getSearchResultsFromInplantTraining(trimCourseName,
                studentId);
        List<Certificate>  certificates = certificateDao.getSearchResultsFromCertificate(trimCourseName, studentId);

        List<TrainingProgram> trainingPrograms = new ArrayList<>();
        trainingPrograms.addAll(workshops);
        trainingPrograms.addAll(inplantTrainings);
        trainingPrograms.addAll(certificates);

        return trainingPrograms.stream().sorted().collect(Collectors.toList());

    }

}
