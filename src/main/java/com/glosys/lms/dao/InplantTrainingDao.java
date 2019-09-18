package com.glosys.lms.dao;

import com.glosys.lms.entity.InplantTraining;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class InplantTrainingDao extends AbstractDao<InplantTraining> {
    public InplantTrainingDao() {
        super();
    }

    public InplantTrainingDao(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<InplantTraining> getInplantTrainings(int trainerId){
            try{
                entityManager.getTransaction().begin();
                Query query = entityManager.createQuery("SELECT ip FROM InplantTraining ip WHERE " +
                        "ip.trainer.id=:trainerId " +
                        "AND ip.date >= CURRENT_DATE");
                query.setParameter("trainerId", trainerId);
                entityManager.getTransaction().commit();
                return query.getResultList();

            }catch (Exception e){
                if(entityManager.getTransaction().isActive()){
                    entityManager.getTransaction().rollback();
                }
                throw new  RuntimeException("Can not get inplant trainings for trainer");
            }

        }


    

}
