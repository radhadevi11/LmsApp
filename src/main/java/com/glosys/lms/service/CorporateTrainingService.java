package com.glosys.lms.service;

import com.glosys.lms.entity.CorporateTrainingType;
import com.glosys.lms.entity.Course;
import com.glosys.lms.dao.DaoFactory;

import java.util.List;

public class CorporateTrainingService {
    public List<CorporateTrainingType> getCorporateTrainings(){
        return DaoFactory.getCorporateTrainingTypeDao().getCorporateTrainingTypes();
    }

    public List<Course> getCoursesForCorporateTraining(){
        return DaoFactory.getCourseDao().getCoursesForCorporateTraining();
    }
}
