package com.glosys.lms.controller;

import com.glosys.lms.entity.CourseCategory;
import com.glosys.lms.service.CourseCategoryService;

import java.util.List;

public class CourseCategoryController {
    private static CourseCategoryService courseCategoryService = new CourseCategoryService();

    public List<CourseCategory> getCourseCategories(){
        return courseCategoryService.getCourseCategories();
    }
}
