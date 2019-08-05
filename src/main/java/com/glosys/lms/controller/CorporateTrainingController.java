package com.glosys.lms.controller;

import com.glosys.lms.model.CorporateTrainingInfo;
import com.glosys.lms.service.CorporateTrainingService;

public class CorporateTrainingController {
    private static CorporateTrainingService corporateTrainingService = new CorporateTrainingService();

    public CorporateTrainingInfo getCorporateTrainingInfo(){
        return new CorporateTrainingInfo(corporateTrainingService.getCorporateTrainings(),
                corporateTrainingService.getCoursesForCorporateTraining());
    }
}
