package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.AssignmentDao;
import com.example.AssessmentProject.dao.TrainingMaterialDoa;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.entity.TrainingMaterial;
import com.example.AssessmentProject.service.AssignmentService;
import com.example.AssessmentProject.service.TrainingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/material")
public class TrainingMaterialController {

    @Autowired
    TrainingMaterialService trainingMaterialService;

    @PostMapping("")
    public ResponseEntity<Object> addTrainingMaterial(@RequestBody TrainingMaterialDoa trainingMaterialDoa){

        TrainingMaterial trainingMaterial = new TrainingMaterial(trainingMaterialDoa.getAssessmentId(),trainingMaterialDoa.getTrainingMaterialType(), trainingMaterialDoa.getContent());
        String response = trainingMaterialService.addTrainingMaterial(trainingMaterial);

        if(response.equals("training material added")){
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
