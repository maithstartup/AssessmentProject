package com.example.AssessmentProject.controller;
import com.example.AssessmentProject.dao.AssessmentDao;
import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assessment")
public class AssessmentController {

    @Autowired
    AssessmentService assessmentService;

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
