package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.AssignmentDao;
import com.example.AssessmentProject.dao.QuizDao;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.entity.Quiz;
import com.example.AssessmentProject.service.AssignmentService;
import com.example.AssessmentProject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @PostMapping("")
    public ResponseEntity<Object> addQuiz(@RequestBody AssignmentDao assignmentDao){

        Assignment assignment = new Assignment(assignmentDao.getAssessmentId(), assignmentDao.getQuestion(), assignmentDao.getAnswer(), assignmentDao.getAssignmentScore());
        String response = assignmentService.addAssignment(assignment);

        if(response.equals("assignment added")){
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
