package com.glosys.lms.controller;

import com.glosys.lms.CourseCategory;
import service.CourseCategoryService;

import java.util.List;

public class CourseCategoryController {
    private static CourseCategoryService courseCategoryService = new CourseCategoryService();

    public List<CourseCategory> getCourseCategories(){
        return courseCategoryService.getCourseCategories();
    }
}
