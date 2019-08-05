package com.glosys.lms.dao;

import com.glosys.lms.entity.Admin;

import javax.persistence.Query;

public class AdminDao extends AbstractDao<Admin> {

    public boolean isValidAdmin(String name, String password) {
        long count = 0;


        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select count(admin) from Admin admin where admin.name=:name" +
                    " and admin.password=:password");
            query.setParameter("name", name);
            query.setParameter("password", password);
            count = (long) query.getSingleResult();
            entityManager.getTransaction().commit();

        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }


        if(count == 1){
            return true;
        }
        else {
            return false;
        }

    }

}
