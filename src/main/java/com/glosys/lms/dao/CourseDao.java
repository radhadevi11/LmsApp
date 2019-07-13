package com.glosys.lms.dao;


import com.glosys.lms.Course;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseDao extends AbstractDao<Course> {

    public CourseDao() {
        super();
    }

    public CourseDao(EntityManager entityManager) {
        super(entityManager);
    }


    public List<Course> getCoursesForWorkshop() {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.workshopEligibility=TRUE",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
           throw new RuntimeException("can not get courses for workshop",e);
        }

    }

    public List<Course> getCoursesForInplantTraining(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.inplantTrainingEligibility=TRUE",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get courses for Inplant training",e);
        }
    }

    public List<Course> getCoursesForCorporateTraining(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.corporateTrainingEligibility=TRUE",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get courses for Inplant training",e);
        }
    }

    public boolean isExistingCourse(String courseCode){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.code=:courseCode",Course.class);
            query.setParameter("courseCode",courseCode);
            entityManager.getTransaction().commit();
            if(query.getResultList().size() == 0){
                return false;
            }
            else{
                return true;
            }

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get courses ",e);
        }



    }



}
