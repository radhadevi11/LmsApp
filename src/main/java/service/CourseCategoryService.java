package service;

import com.glosys.lms.CourseCategory;
import com.glosys.lms.dao.DaoFactory;

import java.util.List;

public class CourseCategoryService {
    public List<CourseCategory> getCourseCategories(){
        return DaoFactory.getCourseCategoryDao().getCourseCategories();
    }
}
