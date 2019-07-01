package service;

import com.glosys.lms.Course;
import com.glosys.lms.WorkshopType;
import com.glosys.lms.dao.DaoFactory;

import java.util.List;

public class WorkshopService {
    public List<WorkshopType> getWorkshopTypes(){
       return DaoFactory.getWorkshopTypeDao().getWorkshopTypes();
    }

    public List<Course> getCourses() {
        return DaoFactory.getCourseDao().getCoursesForWorkshop();
    }
}
