package com.example.AssessmentProject.controller;
import com.example.AssessmentProject.dao.AssessmentDao;
import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessment")
public class AssessmentController {

    @Autowired
    AssessmentService assessmentService;


   @GetMapping("/id/{assessmentId}")
   public ResponseEntity<Object> getAssessmentById(@PathVariable("assessmentId") Integer assessmentId){
       Assessment assessment = assessmentService.getAssessmentById(assessmentId);
       if(assessment != null)
           return ResponseEntity.ok().body(assessment);
       else
           return  ResponseEntity.badRequest().body("no assessment");

   }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllAssessment(){
        List<Assessment> assessment = assessmentService.getAllAssessment();
        if(assessment != null)
            return ResponseEntity.ok().body(assessment);
        else
            return  ResponseEntity.badRequest().body("no assessment");

    }

    @PutMapping("/id/{assessmentId}")
    public ResponseEntity<Object> updateAssessmentById(@PathVariable("assessmentId") Integer assessmentId, @RequestBody AssessmentDao assessmentDao){
        Assessment assessment = new Assessment(assessmentDao.getAssessmentName(), assessmentDao.getType(),assessmentDao.getScore(),assessmentDao.getDescription(), assessmentDao.getCourseId(),assessmentDao.getTrainerId());
        Assessment assessment1 = assessmentService.updateAssessmentById(assessmentId,assessment);
        if(assessment1 != null)
            return ResponseEntity.ok().body(assessment1);
        else
            return  ResponseEntity.badRequest().body("unable to update assessment");
    }

    @DeleteMapping("/id/{assessmentId}")
    public ResponseEntity<Object> deleteAssessmentById(@PathVariable("assessmentId") Integer assessmentId){
        String response = assessmentService.deleteAssessmentById(assessmentId);

        if(response.equals("assessment deleted"))
            return ResponseEntity.ok().body(response);
        else
            return  ResponseEntity.badRequest().body(response);
    }


   @PostMapping("")
   public ResponseEntity<Object> addAssessment(@RequestBody AssessmentDao assessmentDao){

        Assessment assessment = new Assessment(assessmentDao.getAssessmentName(), assessmentDao.getType(),assessmentDao.getScore(),assessmentDao.getDescription(), assessmentDao.getCourseId(),assessmentDao.getTrainerId());
        String response = assessmentService.addAssessment(assessment);

        if(response.equals("added")){
            return ResponseEntity.accepted().body("added");
        }
        return ResponseEntity.badRequest().body("not added");
   }

}
