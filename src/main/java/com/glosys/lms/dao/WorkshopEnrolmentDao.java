package com.glosys.lms.dao;

import com.glosys.lms.entity.Workshop;
import com.glosys.lms.entity.WorkshopEnrolment;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class WorkshopEnrolmentDao extends AbstractDao<WorkshopEnrolment> {
    public WorkshopEnrolmentDao() {super();}

    public WorkshopEnrolmentDao(EntityManager entityManager){
        super(entityManager);
    }

    public List<Workshop> getAvailableWorkshopForStudent(int studentId){
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT w FROM Workshop w WHERE " +
                    "NOT EXISTS (SELECT wE.workshop.id FROM WorkshopEnrolment wE " +
                    "WHERE wE.workshop.id=w.id AND wE.student.id=:studentId OR wE.workshop.date < CURRENT_DATE");
            query.setParameter("studentId", studentId);
            List<Workshop> workshops = query.getResultList();
            entityManager.getTransaction().commit();
            return workshops;
        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not get future workshops");
        }

    }

    public List<WorkshopEnrolment> getEnrolmentsByStudentId(int studentId){
        try{
            entityManager.getTransaction().begin();
            TypedQuery<WorkshopEnrolment> query = (TypedQuery<WorkshopEnrolment>) entityManager.createQuery("SELECT " +
                    "wE from WorkshopEnrolment wE WHERE wE.student.id=:studentId");
            query.setParameter("studentId",studentId);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get enrolments by student id ",e);
        }
    }


}
