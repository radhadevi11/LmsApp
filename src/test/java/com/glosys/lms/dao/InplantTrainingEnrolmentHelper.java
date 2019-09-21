package com.glosys.lms.dao;

import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.InplantTrainingEnrolment;
import com.glosys.lms.entity.Student;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class InplantTrainingEnrolmentHelper {
    public InplantTrainingEnrolment save(EntityManager em){
        InplantTrainingEnrolmentDao inplantTrainingEnrolmentDao = new InplantTrainingEnrolmentDao(em);
        Student student = new StudentHelper().save(em);
        InplantTraining inplantTraining = new InplantTrainingHelper().save(em, LocalDate.now());
        return inplantTrainingEnrolmentDao.save(
                new InplantTrainingEnrolment(student, inplantTraining));
    }
}
