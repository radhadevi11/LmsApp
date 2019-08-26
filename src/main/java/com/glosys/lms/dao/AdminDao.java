package com.glosys.lms.dao;

import com.glosys.lms.entity.Admin;

import javax.persistence.Query;

public class AdminDao extends AbstractDao<Admin> {

    public boolean isValidAdmin(String name, String password) {


        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select count(admin) from Admin admin where admin.name=:name" +
                    " and admin.password=:password");
            query.setParameter("name", name);
            query.setParameter("password", password);
            long count = (long) query.getSingleResult();
            entityManager.getTransaction().commit();
            if(count == 1){
                return true;
            }
            else {
                return false;
            }

        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
           throw new RuntimeException("can not get valid admin",e);
        }



    }

}
