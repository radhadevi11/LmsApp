package com.glosys.lms.dao;

import com.glosys.lms.WorkshopType;

import java.util.List;

import static org.junit.Assert.*;

public class WorkshopTypeDaoTest {
    public static void main(String[] args) {
        WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao();
        List<WorkshopType> workshopTypes = workshopTypeDao.getWorkshopTypes();
        System.out.println(workshopTypes);
    }

}