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

        public List<Workshop> getFutureWorkshops(){
            try {
                entityManager.getTransaction().begin();
                TypedQuery<Workshop> query = (TypedQuery<Workshop>) entityManager.createQuery("SELECT w FROM Workshop w " +
                        "where w.date > CURRENT_DATE");
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

}
