package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.TrainingMaterialDao;
import com.example.AssessmentProject.entity.TrainingMaterial;
import com.example.AssessmentProject.service.TrainingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/material")
public class TrainingMaterialController {

    @Autowired
    TrainingMaterialService trainingMaterialService;

    @PostMapping("")
    public ResponseEntity<Object> addTrainingMaterial(@RequestBody TrainingMaterialDao trainingMaterialDao){

        TrainingMaterial trainingMaterial = new TrainingMaterial(trainingMaterialDao.getAssessmentId(),trainingMaterialDao.getTrainingMaterialType(), trainingMaterialDao.getContent());
        String response = trainingMaterialService.addTrainingMaterial(trainingMaterial);

        if(response.equals("training material added")){
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
    @GetMapping("/id/{trainingMaterialId}")
    public ResponseEntity<Object> getAssessmentById(@PathVariable("trainingMaterialId") Integer trainingMaterialId){
        TrainingMaterial trainingMaterial = trainingMaterialService.getTrainingMaterialById(trainingMaterialId);
        if(trainingMaterial != null)
            return ResponseEntity.ok().body(trainingMaterial);
        else
            return  ResponseEntity.badRequest().body("no trainingMaterial");

    }

    @GetMapping("/{assessmentId}")
    public ResponseEntity<Object> getTrainingMaterialByAssessmentId(@PathVariable("assessmentId") Integer assessmentId){
        List<TrainingMaterial> trainingMaterials = trainingMaterialService.getTrainingMaterialByAssessmentId(assessmentId);

        if(trainingMaterials != null)
            return ResponseEntity.ok().body(trainingMaterials);
        else
            return  ResponseEntity.badRequest().body("no trainingMaterials");

    }

    @PutMapping("/id/{trainingMaterialId}")
    public ResponseEntity<Object> updateTrainingMaterialById(@PathVariable("trainingMaterialId") Integer trainingMaterialId, @RequestBody TrainingMaterialDao trainingMaterialDao){
        TrainingMaterial trainingMaterial = new TrainingMaterial(trainingMaterialDao.getAssessmentId(),trainingMaterialDao.getTrainingMaterialType(), trainingMaterialDao.getContent());
        TrainingMaterial trainingMaterial1 = trainingMaterialService.updateTrainingMaterialById(trainingMaterialId,trainingMaterial);
        if(trainingMaterial1 != null)
            return ResponseEntity.ok().body(trainingMaterial1);
        else
            return  ResponseEntity.badRequest().body("unable to update trainingMaterial");
    }

    @DeleteMapping("/id/{trainingMaterialId}")
    public ResponseEntity<Object> deleteTrainingMaterialById(@PathVariable("trainingMaterialId") Integer trainingMaterialId){
        String response = trainingMaterialService.deleteTrainingMaterialById(trainingMaterialId);
        if(response.equals("training material deleted"))
            return ResponseEntity.ok().body(response);
        else
            return  ResponseEntity.badRequest().body(response);
    }

}
