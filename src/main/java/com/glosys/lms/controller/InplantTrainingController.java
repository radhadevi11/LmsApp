package com.glosys.lms.controller;

import com.glosys.lms.model.InplantTrainingInfo;
import service.InplantTrainingService;

public class InplantTrainingController {
    private static InplantTrainingService inplantTrainingService = new InplantTrainingService();

    public InplantTrainingInfo getInplantTrainingInfo(){
        return new InplantTrainingInfo(inplantTrainingService.getInplantTrainingTypes(),
                inplantTrainingService.getCoursesForInplantTraining());
    }
}
