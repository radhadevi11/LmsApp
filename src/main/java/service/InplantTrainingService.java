package service;

import com.glosys.lms.Course;
import com.glosys.lms.InplantTrainingType;
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
