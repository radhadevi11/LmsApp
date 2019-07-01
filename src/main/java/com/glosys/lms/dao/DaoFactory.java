package com.glosys.lms.dao;

public class DaoFactory {

    private static StudentDaoImpl studentDao = new StudentDaoImpl();
    private static LoginDao loginDao = new LoginDao();
    private static TrainingProgramTypeDao trainingProgramTypeDao = new TrainingProgramTypeDao();
    private static WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao();
    private static CourseDao courseDao = new CourseDao();
    private static CourseCategoryDao courseCategoryDao = new CourseCategoryDao();
    private static InplantTrainingTypeDao inplantTrainingTypeDao = new InplantTrainingTypeDao();
    private static CorporateTrainingTypeDao corporateTrainingTypeDao = new CorporateTrainingTypeDao();

    public static StudentDaoImpl getStudentDao(){
        return studentDao;
    }

    public static LoginDao getLoginDao(){return loginDao;}

    public static TrainingProgramTypeDao getTrainingProgramTypeDao() {
        return trainingProgramTypeDao;
    }

    public static WorkshopTypeDao getWorkshopTypeDao() {
        return workshopTypeDao;
    }

    public static CourseDao getCourseDao() {
        return courseDao;
    }

    public static CourseCategoryDao getCourseCategoryDao() {
        return courseCategoryDao;
    }

    public static InplantTrainingTypeDao getInplantTrainingTypeDao() {
        return inplantTrainingTypeDao;
    }

    public static CorporateTrainingTypeDao getCorporateTrainingTypeDao() {
        return corporateTrainingTypeDao;
    }
}
