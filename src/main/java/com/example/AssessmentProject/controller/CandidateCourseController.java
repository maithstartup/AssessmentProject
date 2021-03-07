package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.CandidateCourseDao;
import com.example.AssessmentProject.service.CandidateCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course/score")
public class CandidateCourseController {

    @Autowired
    CandidateCourseService candidateCourseService;

    @PostMapping("")
    public ResponseEntity<Object> addCandidateCourse(@RequestBody CandidateCourseDao candidateCourseDao){


        String response = candidateCourseService.addCandidateCourse(candidateCourseDao);

        if(response.equals("added")){
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

}
