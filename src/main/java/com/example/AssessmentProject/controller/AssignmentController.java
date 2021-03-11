package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.AssignmentDao;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @PostMapping("")
    public ResponseEntity<Object> addAssignment(@RequestBody AssignmentDao assignmentDao){

        Assignment assignment = new Assignment(assignmentDao.getAssessmentId(), assignmentDao.getQuestion(), assignmentDao.getAnswer(), assignmentDao.getAssignmentScore());
        String response = assignmentService.addAssignment(assignment);

        if(response.equals("assignment added")){
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/id/{assignmentId}")
    public ResponseEntity<Object> getAssignmentById(@PathVariable("assignmentId") Integer assignmentId){
        Assignment assignment = assignmentService.getAssignmentById(assignmentId);
        if(assignment != null)
            return ResponseEntity.ok().body(assignment);
        else
            return  ResponseEntity.badRequest().body("no assignment");

    }

    @GetMapping("/{assessmentId}")
    public ResponseEntity<Object> getAssignmentByAssessmentId(@PathVariable("assessmentId") Integer assessmentId){
        List<Assignment> assignments = assignmentService.getAssignmentByAssessmentId(assessmentId);

        if(assignments != null)
            return ResponseEntity.ok().body(assignments);
        else
            return  ResponseEntity.badRequest().body("no assignments");

    }

    @PutMapping("/id/{assignmentId}")
    public ResponseEntity<Object> updateAssignmentById(@PathVariable("assignmentId") Integer assignmentId, @RequestBody AssignmentDao assignmentDao){
        Assignment assignment = new Assignment(assignmentDao.getAssessmentId(),assignmentDao.getQuestion(),assignmentDao.getAnswer(),assignmentDao.getAssignmentScore());
        Assignment assignment1 = assignmentService.updateAssignmentById(assignmentId,assignment);
        if(assignment1 != null)
            return ResponseEntity.ok().body(assignment1);
        else
            return  ResponseEntity.badRequest().body("unable to update assignment");
    }

    @DeleteMapping("/id/{assignmentId}")
    public ResponseEntity<Object> deleteAssignmentById(@PathVariable("assignmentId") Integer assignmentId){
        String response = assignmentService.deleteAssignmentById(assignmentId);
        if(response.equals("assignment deleted"))
            return ResponseEntity.ok().body(response);
        else
            return  ResponseEntity.badRequest().body(response);
    }

}
