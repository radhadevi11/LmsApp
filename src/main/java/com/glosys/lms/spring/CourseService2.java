package com.glosys.lms.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseService2 {

   private CourseDao2 courseDao2;
   @Autowired
   public CourseService2(CourseDao2 courseDao2) {
      this.courseDao2 = courseDao2;
   }


   public boolean isExistingCourse(String courseCode){ return courseDao2.isExistingCourse(courseCode); }

}
