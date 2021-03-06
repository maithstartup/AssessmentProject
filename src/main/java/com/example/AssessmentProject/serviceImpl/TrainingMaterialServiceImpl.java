package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.TrainingMaterial;
import com.example.AssessmentProject.repository.TrainingMaterialRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.AssignmentService;
import com.example.AssessmentProject.service.TrainingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingMaterialServiceImpl implements TrainingMaterialService {

    @Autowired
    AssessmentService assessmentService;

    @Autowired
    TrainingMaterialRepository trainingMaterialRepository;

    public String addTrainingMaterial(TrainingMaterial trainingMaterial){

        Integer assessmentId=trainingMaterial.getAssessmentId();
        Assessment assessment = assessmentService.getAssessmentById(assessmentId);
        if(assessment != null ){

            trainingMaterialRepository.save(trainingMaterial);
            return "training material added";
        }
        return "unable to add training material";
    }
}
