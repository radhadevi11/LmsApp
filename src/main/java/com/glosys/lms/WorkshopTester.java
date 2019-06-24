package com.glosys.lms;

import javax.persistence.*;
import java.util.List;

public class WorkshopTester {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("com.radha.lms");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            //insert workshop object

            //delete entity


            entityManager.getTransaction().commit();
            //get the id of the persisted object
            //get the count of all the workshop object from the table
            Query query = entityManager.createQuery("select count(workshop) from Workshop workshop");
            System.out.println("The count is "+query.getSingleResult());
            //get all the workshop object from table
            TypedQuery<Workshop> workshopTypedQuery = entityManager.createQuery("select workshop from Workshop workshop",
                    Workshop.class);
            List<Workshop> workshops = workshopTypedQuery.getResultList();
            for(Workshop workshop1 : workshops){
                System.out.println(workshop1);
            }


        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }

    }
}
