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
    
    public Trainer getValidTrainer(String userName, String password){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Trainer> query = entityManager.createQuery("select t from Trainer t where " +
                    "t.userName=:userName and t.password=:password", Trainer.class);
            query.setParameter("userName", userName);
            query.setParameter("password", password);
            entityManager.getTransaction().commit();
            List<Trainer> trainers = query.getResultList();
            if(trainers.size() == 1){
                return trainers.get(0);
            }
            else {
                return null;
            }

        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not get valid Trainer",e);
        }
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
    public boolean isExistingUserName(String userName) {


        try {
            entityManager.getTransaction().begin();
            TypedQuery<Trainer> query = entityManager.createQuery("select count(*) from Trainer trainer where " +
                    "trainer.userName=:userName", Trainer.class);
            query.setParameter("userName", userName);
            entityManager.getTransaction().commit();
            List<Trainer> trainers = query.getResultList();
            if(trainers.size() == 0){
                return false;
            }
            else {
                return true;
            }

        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not get existing user name",e);
        }

    }

}
