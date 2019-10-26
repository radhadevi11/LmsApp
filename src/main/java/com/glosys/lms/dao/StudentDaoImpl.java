package com.glosys.lms.dao;

import com.glosys.lms.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDaoImpl extends AbstractDao<Student> {
    public StudentDaoImpl(){
        super();
    }
    public StudentDaoImpl(EntityManager entityManager){
        super(entityManager);
    }


    public boolean isExistingMailId(String mailId) {


        try {
            entityManager.getTransaction().begin();
            TypedQuery<Student> query = entityManager.createQuery("select student from Student student where " +
                    "student.mailId=:mailId", Student.class);
            query.setParameter("mailId", mailId);
            entityManager.getTransaction().commit();
            List<Student> students = query.getResultList();
            if(students.size() == 0){
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
            throw new RuntimeException("Can not get existing mail id",e);
        }

    }

}
