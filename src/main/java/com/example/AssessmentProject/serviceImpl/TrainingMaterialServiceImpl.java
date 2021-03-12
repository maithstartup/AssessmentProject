package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.entity.TrainingMaterial;
import com.example.AssessmentProject.repository.TrainingMaterialRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.AssignmentService;
import com.example.AssessmentProject.service.TrainingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public TrainingMaterial getTrainingMaterialById(Integer trainingMaterialId){
        Optional<TrainingMaterial> trainingMaterialOptional = trainingMaterialRepository.findById(trainingMaterialId);

        if(trainingMaterialOptional.isPresent())
        {
            return trainingMaterialOptional.get();
        }
        return null;
    }

    public List<TrainingMaterial> getTrainingMaterialByAssessmentId(Integer assessmentID){

        Assessment assessment = assessmentService.getAssessmentById(assessmentID);

        if(assessment != null)
        {
            List<TrainingMaterial> trainingMaterialList = new ArrayList<>();
            trainingMaterialList.addAll(assessment.getTrainingMaterials());
            return trainingMaterialList;
        }
        return null;

    }

    public TrainingMaterial updateTrainingMaterialById(Integer trainingMaterialId,TrainingMaterial trainingMaterial){

        Optional<TrainingMaterial> trainingMaterialOptional = trainingMaterialRepository.findById(trainingMaterialId);
        if(trainingMaterialOptional.isPresent())
        {
            TrainingMaterial trainingMaterial1 = trainingMaterialOptional.get();

            trainingMaterial1.setTrainingMaterialType(trainingMaterial.getTrainingMaterialType());
            trainingMaterial1.setAssessmentId(trainingMaterial.getAssessmentId());
            trainingMaterial1.setContent(trainingMaterial.getContent());

            trainingMaterialRepository.save(trainingMaterial1);
            return trainingMaterial1;

        }
        return null;
    }

    public String deleteTrainingMaterialById(Integer trainingMaterialId){
        Optional<TrainingMaterial> trainingMaterialOptional = trainingMaterialRepository.findById(trainingMaterialId);

        if(trainingMaterialOptional.isPresent())
        {
            trainingMaterialRepository.deleteById(trainingMaterialId);
            return "training material deleted";
        }
        return null;
    }

}
