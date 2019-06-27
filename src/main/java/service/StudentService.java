package service;

import com.glosys.lms.Student;
import com.glosys.lms.dao.DaoFactory;

public class StudentService {
    public void saveStudent(Student student){
        DaoFactory.getStudentDao().save(student);
    }

}
