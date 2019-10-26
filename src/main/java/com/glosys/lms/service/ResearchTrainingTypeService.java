package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.ResearchTrainingType;

import java.util.List;

public class ResearchTrainingTypeService {
    public List<ResearchTrainingType> getResearchTrainings(){
        return DaoFactory.getResearchTrainingTypeDao().getResearchTrainings();
    }

    public List<Course> getCoursesForResearchTraining(){
        return DaoFactory.getCourseDao().getCoursesForResearchTraining();
    }
}
