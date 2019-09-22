package com.glosys.lms.service;

import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.ResearchTrainingType;
import com.glosys.lms.dao.DaoFactory;

import java.util.List;

public class ResearchTrainingService {
    public List<ResearchTrainingType> getResearchTrainings(){
        return DaoFactory.getResearchTrainingDao().getResearchTrainings();
    }

    public List<Course> getCoursesForResearchTraining(){
        return DaoFactory.getCourseDao().getCoursesForResearchTraining();
    }
}
