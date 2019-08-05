package com.glosys.lms.dao;

import com.glosys.lms.entity.WorkshopType;

import java.util.List;

public class WorkshopTypeDaoTest {
    public static void main(String[] args) {
        WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao();
        List<WorkshopType> workshopTypes = workshopTypeDao.getWorkshopTypes();
        System.out.println(workshopTypes);
    }

}