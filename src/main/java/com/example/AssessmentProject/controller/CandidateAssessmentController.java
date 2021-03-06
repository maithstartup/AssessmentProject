package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.AssessmentDao;
import com.example.AssessmentProject.dao.CandidateAssessmentDoa;
import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.CandidateAssessment;
import com.example.AssessmentProject.service.CandidateAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assessment/score")
public class CandidateAssessmentController {

    @Autowired
    CandidateAssessmentService candidateAssessmentService;

    @PostMapping("")
    public ResponseEntity<Object> addCandidateAssessment(@RequestBody CandidateAssessmentDoa candidateAssessmentDoa){


        String response = candidateAssessmentService.addCandidateAssessment(candidateAssessmentDoa);

        if(response.equals("candidate score added")){
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

}
