package com.glosys.lms.dao;

import com.glosys.lms.entity.Trainer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class TrainerDao extends AbstractDao<Trainer> {
    public TrainerDao() {
        super();
    }

    public TrainerDao(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Trainer> getAvailableTrainers(LocalDate workshopDate){
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT t FROM Trainer t " +
                    "WHERE NOT EXISTS(SELECT w.trainer.id FROM Workshop w " +
                    "WHERE w.trainer.id = t.id AND w.date=:workshopDate)");
            query.setParameter("workshopDate", workshopDate);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not get Available Trainer ", e);
        }

    }

    public List<Trainer> getAllTrainers(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Trainer> query = entityManager.createQuery("SELECT t FROM Trainer t",
                    Trainer.class);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get all Trainers",e);
        }
    }
}
