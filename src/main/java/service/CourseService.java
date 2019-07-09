package service;

import com.glosys.lms.Course;
import com.glosys.lms.dao.CourseDao;
import com.glosys.lms.dao.DaoFactory;

public class CourseService {
   public void saveCourse(Course course){
       DaoFactory.getCourseDao().save(course);
   }

   public boolean isExistingCourse(String courseCode){ return DaoFactory.getCourseDao().isExistingCourse(courseCode); }
}
