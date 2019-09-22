package com.glosys.lms.dao;

import com.glosys.lms.entity.Certificate;
import com.glosys.lms.entity.CertificateEnrolment;
import com.glosys.lms.entity.Student;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class CertificateEnrolmentHelper {
    public CertificateEnrolment save(EntityManager em){
        CertificateEnrolmentDao certificateEnrolmentDao = new CertificateEnrolmentDao(em);
        Certificate certificate = new CertificateHelper().save(em, LocalDate.now());
        Student student = new StudentHelper().save(em);
        CertificateEnrolment certificateEnrolment = new CertificateEnrolment(certificate, student);
        return certificateEnrolmentDao.save(certificateEnrolment);
    }
}
