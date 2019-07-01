package com.glosys.lms.dao;

import com.glosys.lms.CourseCategory;

import javax.persistence.TypedQuery;
import java.util.List;

public class CourseCategoryDao extends AbstractDao<CourseCategory> {

    @Override
    protected CourseCategory createObject(CourseCategory courseCategory) {
        return null;
    }

    public List<CourseCategory> getCourseCategories(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<CourseCategory> query = entityManager.createQuery("SELECT cc FROM CourseCategory cc",
                    CourseCategory.class);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get Course category",e);
        }
    }
}
