package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.WorkshopEnrolment;

import java.util.List;

public class WorkshopEnrolmentService {
    public void saveWorkshopEnrolment(WorkshopEnrolment workshopEnrolment){
         DaoFactory.getWorkshopEnrolmentDao().save(workshopEnrolment);

    }

    public List<WorkshopEnrolment> getAvailableWorkshopsForStudent(int studentId){
        return DaoFactory.getWorkshopEnrolmentDao().getAvailableWorkshopForStudent(studentId);
    }

    public List<WorkshopEnrolment> getEnrolmentsByStudentId(int studentId){
        return DaoFactory.getWorkshopEnrolmentDao().getEnrolmentsByStudentId(studentId);
    }
}
