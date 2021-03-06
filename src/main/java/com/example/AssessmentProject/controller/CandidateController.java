package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.CandidateDao;
import com.example.AssessmentProject.dao.CourseDao;
import com.example.AssessmentProject.entity.Candidate;
import com.example.AssessmentProject.entity.Course;
import com.example.AssessmentProject.service.CandidateService;
import com.example.AssessmentProject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping("")
    public ResponseEntity<Object> addCourse(@RequestBody CandidateDao candidateDao) {

        Candidate candidate = new Candidate(candidateDao.getCandidateId(), candidateDao.getCandidateName(), candidateDao.getLocation(), candidateDao.getCandidateEmail(), candidateDao.getBatch());
        String response = candidateService.addCandidate(candidate);

        if (response.equals("added")) {
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
