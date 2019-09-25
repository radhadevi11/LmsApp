package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.Certificate;

import java.util.List;

public class CertificateService {
    public List<Certificate> getCertificatesByCourseCategoryId(int courseCategoryId){
        return DaoFactory.getCertificateDao().getCertificatesByCourseCategoryId(courseCategoryId);
    }
}
