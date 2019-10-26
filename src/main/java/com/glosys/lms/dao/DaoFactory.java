package com.glosys.lms.dao;

import com.glosys.lms.entity.ResearchTrainingType;

public class DaoFactory {

    private static StudentDaoImpl studentDao = new StudentDaoImpl();
    private static LoginDao loginDao = new LoginDao();
    private static WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao();
    private static CourseDao courseDao = new CourseDao();
    private static CourseCategoryDao courseCategoryDao = new CourseCategoryDao();
    private static InplantTrainingTypeDao inplantTrainingTypeDao = new InplantTrainingTypeDao();
    private static CorporateTrainingTypeDao corporateTrainingTypeDao = new CorporateTrainingTypeDao();
    private static ResearchTrainingDao researchTrainingDao = new ResearchTrainingDao();
    private static ResearchTrainingTypeDao researchTrainingTypeDao = new ResearchTrainingTypeDao();
    private static AdminDao adminDao = new AdminDao();
    private static WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao();
    private static WorkshopDao workshopDao = new WorkshopDao();
    private static PaymentDao paymentDao = new PaymentDao();
    private static TrainerDao trainerDao = new TrainerDao();
    private static InplantTrainingDao  inplantTrainingDao = new InplantTrainingDao();
    private static CertificateDao certificateDao = new CertificateDao();

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


    public static WorkshopDao getWorkshopDao() {
        return workshopDao;
    }

    public static PaymentDao getPaymentDao() {
        return paymentDao;
    }

    public static TrainerDao getTrainerDao() {
        return trainerDao;
    }

    public static InplantTrainingDao getInplantTrainingDao() {
        return inplantTrainingDao;
    }

    public static CertificateDao getCertificateDao() {
        return certificateDao;
    }

    public static ResearchTrainingTypeDao getResearchTrainingTypeDao() {
        return researchTrainingTypeDao;
    }
}
