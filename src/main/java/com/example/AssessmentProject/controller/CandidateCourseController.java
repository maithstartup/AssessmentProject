package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.CandidateCourseDao;
import com.example.AssessmentProject.service.CandidateCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("location/{assessmentId}")
    public ResponseEntity<Object> getLocationCount(@PathVariable("assessmentId") Integer assessmentId) {


        Map<String, List<String>> response = candidateCourseService.locationCount(assessmentId);

        if (response != null) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);

    }

}
