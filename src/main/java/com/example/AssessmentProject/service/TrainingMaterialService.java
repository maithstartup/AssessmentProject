package com.example.AssessmentProject.service;

import com.example.AssessmentProject.entity.TrainingMaterial;

import java.util.List;

public interface TrainingMaterialService {

    public String addTrainingMaterial(TrainingMaterial trainingMaterial);

    public TrainingMaterial getTrainingMaterialById(Integer trainingMaterialId);

    public List<TrainingMaterial> getTrainingMaterialByAssessmentId(Integer assessmentId);

    public TrainingMaterial updateTrainingMaterialById(Integer trainingMaterialId,TrainingMaterial trainingMaterial);

    public String deleteTrainingMaterialById(Integer assignmentId);
}
