package com.glosys.lms.service;

import com.glosys.lms.entity.Course;
import com.glosys.lms.dao.DaoFactory;

import java.util.List;

public class CourseService {
   public void saveCourse(Course course){
       DaoFactory.getCourseDao().save(course);
   }

   public boolean isExistingCourse(String courseCode){ return DaoFactory.getCourseDao().isExistingCourse(courseCode); }

   public List<Course> getAllCourse(){ return DaoFactory.getCourseDao().getAllCourse(); }

   public Course getCourseByCourseId(Integer courseId){return DaoFactory.getCourseDao().getCourseByCourseId(courseId);}

   public void updateCourseByCourseId(Course course){
      DaoFactory.getCourseDao().updateCourseByCourseId(course);
   }

   public void deleteCourse(Integer courseId){
      DaoFactory.getCourseDao().deleteCourse(courseId);
   }
}
