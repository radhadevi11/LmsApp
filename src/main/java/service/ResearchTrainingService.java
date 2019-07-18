package service;

import com.glosys.lms.Course;
import com.glosys.lms.ResearchTraining;
import com.glosys.lms.dao.DaoFactory;

import java.util.List;

public class ResearchTrainingService {
    public List<ResearchTraining> getResearchTrainings(){
        return DaoFactory.getResearchTrainingDao().getResearchTrainings();
    }

    public List<Course> getCoursesForResearchTraining(){
        return DaoFactory.getCourseDao().getCoursesForResearchTraining();
    }
}
