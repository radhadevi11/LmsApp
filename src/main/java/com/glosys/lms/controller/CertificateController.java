package com.glosys.lms.controller;

import com.glosys.lms.entity.Certificate;
import com.glosys.lms.service.CertificateService;

import java.util.List;

public class CertificateController {
    private static CertificateService certificateService = new CertificateService();
    public List<Certificate> getCertificatesByCourseCategoryId(int courseCategoryId){
        return certificateService.getCertificatesByCourseCategoryId(courseCategoryId);
    }
}
