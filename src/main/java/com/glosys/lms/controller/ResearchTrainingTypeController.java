package com.glosys.lms.controller;

import com.glosys.lms.entity.ResearchTrainingType;
import com.glosys.lms.model.ResearchTrainingInfo;
import com.glosys.lms.service.ResearchTrainingTypeService;

public class ResearchTrainingTypeController {
    public static ResearchTrainingTypeService researchTrainingTypeService = new ResearchTrainingTypeService();

    public ResearchTrainingInfo getResearchTrainingInfo(){
        return new ResearchTrainingInfo(researchTrainingTypeService.getResearchTrainings(),
                researchTrainingTypeService.getCoursesForResearchTraining());
    }
}
