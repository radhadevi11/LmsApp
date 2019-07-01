package service;

import com.glosys.lms.CorporateTraining;
import com.glosys.lms.CorporateTrainingType;
import com.glosys.lms.Course;
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
