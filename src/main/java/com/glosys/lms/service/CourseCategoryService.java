package com.glosys.lms.service;

import com.glosys.lms.entity.CourseCategory;
import com.glosys.lms.dao.DaoFactory;

import java.util.List;

public class CourseCategoryService {
    public List<CourseCategory> getCourseCategories(){
        return DaoFactory.getCourseCategoryDao().getCourseCategories();
    }
}
