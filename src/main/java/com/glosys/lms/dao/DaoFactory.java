package com.glosys.lms.dao;

public class DaoFactory {

    private static StudentDaoImpl studentDao = new StudentDaoImpl();
    private static LoginDao loginDao = new LoginDao();
    private static TrainingProgramTypeDao trainingProgramTypeDao = new TrainingProgramTypeDao();
    private static WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao();
    private static CourseDao courseDao = new CourseDao();

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
}
