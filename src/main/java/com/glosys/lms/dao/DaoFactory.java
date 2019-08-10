package com.glosys.lms.dao;

public class DaoFactory {

    private static StudentDaoImpl studentDao = new StudentDaoImpl();
    private static LoginDao loginDao = new LoginDao();
    private static WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao();
    private static CourseDao courseDao = new CourseDao();
    private static CourseCategoryDao courseCategoryDao = new CourseCategoryDao();
    private static InplantTrainingTypeDao inplantTrainingTypeDao = new InplantTrainingTypeDao();
    private static CorporateTrainingTypeDao corporateTrainingTypeDao = new CorporateTrainingTypeDao();
    private static ResearchTrainingDao researchTrainingDao = new ResearchTrainingDao();
    private static AdminDao adminDao = new AdminDao();
    private static WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao();

    public static StudentDaoImpl getStudentDao(){
        return studentDao;
    }

    public static LoginDao getLoginDao(){return loginDao;}

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

    public static ResearchTrainingDao getResearchTrainingDao(){ return researchTrainingDao;}

    public static AdminDao getAdminDao() {
        return adminDao;
    }

    public static WorkshopEnrolmentDao getWorkshopEnrolmentDao() { return workshopEnrolmentDao; }


}
