package com.glosys.lms.dao;

import com.glosys.lms.entity.Workshop;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class WorkshopDao extends AbstractDao<Workshop> {
    public WorkshopDao() {super();}

    public WorkshopDao(EntityManager entityManager){
        super(entityManager);
    }

    public boolean isExistingWorkshop(int workshopTypeId, int courseId, LocalDate date){
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT count(w) FROM Workshop w WHERE" +
                    " w.workshopType.id=:workshopTypeId AND w.course.id=:courseId AND w.date=:date");
            query.setParameter("workshopTypeId",workshopTypeId);
            query.setParameter("courseId",courseId);
            query.setParameter("date",date);
            long workshopCount = (long) query.getSingleResult();
            entityManager.getTransaction().commit();
            if(workshopCount == 0){
                return false;
            }
            else {
                return true;
            }

        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get existing workshop ",e);
        }

    }

    public List<Workshop> getAvailableAndFutureWorkshopsByStudentId(int studentId){
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT w FROM Workshop w WHERE w.date > CURRENT_DATE AND " +
                    "NOT EXISTS (SELECT wE.workshop.id FROM WorkshopEnrolment wE " +
                    "WHERE wE.workshop.id=w.id AND wE.student.id=:studentId)");
            query.setParameter("studentId", studentId);
            List<Workshop> workshops = query.getResultList();
            entityManager.getTransaction().commit();
            return workshops;
        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not get future workshops", e);
        }

    }

    public List<Workshop> getWorkshopTrainings(int trainerId) {
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT w FROM Workshop w WHERE w.trainer.id=:trainerId " +
                    "AND w.date >= CURRENT_DATE");
            query.setParameter("trainerId", trainerId);
            entityManager.getTransaction().commit();
            return query.getResultList();

        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not get workshop trainings",e);
        }

    }

    public List<Workshop> getSearchResultsFromWorkshop(String courseName, int studentId){

        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT w FROM Workshop w WHERE w.date >= CURRENT_DATE " +
                    "AND lower(w.course.name) LIKE lower(:courseName) AND" +
                    " NOT EXISTS (SELECT we.workshop.id FROM WorkshopEnrolment we " +
                    "WHERE we.workshop.id=w.id AND we.student.id=:studentId)");
            query.setParameter("courseName",  "%" +courseName+ "%");
            query.setParameter("studentId", studentId);
            entityManager.getTransaction().commit();
            return query.getResultList();

        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not get search result for workshop trainings", e);
        }

    }


}
