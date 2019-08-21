package com.glosys.lms.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static java.time.Month.APRIL;
import static org.junit.Assert.*;

public class CorporateTrainingTypeDaoTest {
    public static void main(String[] args) {
       /* CorporateTrainingTypeDao corporateTrainingTypeDao = new CorporateTrainingTypeDao();
        System.out.println(corporateTrainingTypeDao.getCorporateTrainingTypes());*/
        LocalDate localDate = LocalDate.of(2019,05,25);
        System.out.println(localDate);
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        LocalDate date = LocalDate.of(2015, APRIL, 2);
        System.out.println(APRIL.getValue());
        System.out.println(Month.valueOf("JANUARY"));
        System.out.println(System.currentTimeMillis());
    }

}