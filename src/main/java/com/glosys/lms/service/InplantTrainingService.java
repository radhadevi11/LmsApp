package com.glosys.lms.service;

import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.InplantTrainingType;
import com.glosys.lms.dao.DaoFactory;

import java.util.List;

public class InplantTrainingService {
    public List<InplantTrainingType> getInplantTrainingTypes(){
        return DaoFactory.getInplantTrainingTypeDao().getInplantTrainingTypes();
    }

    public List<Course> getCoursesForInplantTraining(){
        return DaoFactory.getCourseDao().getCoursesForInplantTraining();
    }
}
