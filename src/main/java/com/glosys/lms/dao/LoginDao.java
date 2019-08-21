package com.glosys.lms.dao;

import com.glosys.lms.entity.Login;
import com.glosys.lms.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class LoginDao extends AbstractDao<Login>{


    public LoginDao(EntityManager em) {
        super(em);
    }

    public LoginDao() {
        super();
    }

    public Student getValidUser(String mailId, String password) {


        try {
            entityManager.getTransaction().begin();
            TypedQuery<Student> query = entityManager.createQuery("select student from Student student where student.mailId=:mailId" +
                    " and student.password=:password", Student.class);
            query.setParameter("mailId", mailId);
            query.setParameter("password", password);
            entityManager.getTransaction().commit();
            List<Student> students = query.getResultList();
            if(students.size() == 1){
                return students.get(0);
            }
            else {
                return null;
            }

        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
           throw new RuntimeException("Can not get valid student",e);
        }

    }



}
