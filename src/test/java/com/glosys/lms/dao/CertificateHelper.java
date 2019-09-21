package com.glosys.lms.dao;

import com.glosys.lms.entity.Certificate;
import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.Trainer;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class CertificateHelper {
    public Certificate save(EntityManager entityManager, LocalDate localDate){
        CertificateDao certificateDao = new CertificateDao(entityManager);
        Course course = new CourseHelper().save(entityManager);
        Trainer trainer = new TrainerHelper().save(entityManager, "Radha");
        Certificate certificate = certificateDao.save(new Certificate("certificate", course, localDate,
                trainer));
        return certificate ;
    }
}
