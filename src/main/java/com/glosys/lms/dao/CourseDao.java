package com.glosys.lms.dao;


import com.glosys.lms.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseDao extends AbstractDao<Course> {

    public CourseDao() {
        super();
    }

    public CourseDao(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Course> getAllCourse(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get courses ",e);
        }


    }

    public Course getCourseByCourseId(Integer courseId){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.id=:courseId",Course.class);
            query.setParameter("courseId",courseId);
            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception e) {
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get course for "+courseId,e);
        }

    }

    public Course updateCourseByCourseId(Course course){
        try {
            entityManager.getTransaction().begin();
            Course updatedCourse =  entityManager.merge(course);
            entityManager.getTransaction().commit();
            return  updatedCourse;
        } catch (Exception e) {
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not update courses for workshop",e);
        }
    }




    public List<Course> getCoursesForWorkshop() {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.workshopEligibility=TRUE",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
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
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
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
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get courses for Corporate Training",e);
        }
    }

    public List<Course> getCoursesForResearchTraining(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.researchTrainingEligibility=TRUE",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get courses for ResearchTraining",e);
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
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get courses ",e);
        }



    }

    public void deleteCourse( Integer courseId) {
        try {
            Course course = entityManager.find(Course.class, courseId);
            entityManager.getTransaction().begin();
            entityManager.remove(course);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }


}
