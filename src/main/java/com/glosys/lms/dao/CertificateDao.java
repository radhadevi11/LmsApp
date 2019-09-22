package com.glosys.lms.dao;

import com.glosys.lms.entity.Certificate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CertificateDao extends AbstractDao<Certificate> {
    public CertificateDao() {
        super();
    }

    public CertificateDao(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Certificate> getSearchResultsFromCertificate(String courseName, int studentId){
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT c FROM Certificate c WHERE c.date >= CURRENT_DATE " +
                    "AND lower(c.course.name) LIKE lower(:courseName) AND" +
                    " NOT EXISTS (SELECT cE.certificate.id FROM CertificateEnrolment cE " +
                    "WHERE cE.certificate.id=c.id AND cE.student.id=:studentId)");
            query.setParameter("courseName",  "%" +courseName+ "%");
            query.setParameter("studentId", studentId);
            entityManager.getTransaction().commit();
            return query.getResultList();

        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not get search result for certificate", e);
        }

    }
}
