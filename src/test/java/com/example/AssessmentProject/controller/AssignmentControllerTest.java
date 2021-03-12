package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.AssignmentDao;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.serviceImpl.AssignmentServiceImpl;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.*;


import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AssignmentControllerTest {

    @InjectMocks
    AssignmentController assignmentController;

    @Mock
    AssignmentServiceImpl assignmentService;

    @Mock
    AssessmentService assessmentService;


    @Test
    void addAssignment() {


        AssignmentDao assignmentDao = new AssignmentDao();
        Mockito.when(assignmentService.addAssignment(Mockito.any()))
                .thenReturn("assignment added");

        ResponseEntity<Object> response = assignmentController.addAssignment(assignmentDao);

        Assertions.assertNotNull(response);
    }

    @Test
    void getAssignmentById() {
        Assignment assignment = new Assignment(1,"ques","ans", 0.5F);

        //failure
        Mockito.when(assignmentService.getAssignmentById(Mockito.any()))
                .thenReturn(null);

        ResponseEntity<Object> response = assignmentController.getAssignmentById(Mockito.any());


        Assertions.assertEquals(response,ResponseEntity.badRequest().body("no assignment"));


        //success
        Mockito.when(assignmentService.getAssignmentById(Mockito.any()))
                .thenReturn(assignment);

        ResponseEntity<Object> response2 = assignmentController.getAssignmentById(Mockito.any());
        Assertions.assertEquals(response2,ResponseEntity.ok().body(assignment));

    }

    @Test
    void getAssignmentByAssessmentId() {

        Assignment assignment = new Assignment(1,"ques","ans", 0.5F);
        List <Assignment> assignmentList = new ArrayList<>();
        assignmentList.add(assignment);
        // failure
        Mockito.when(assignmentService.getAssignmentByAssessmentId(anyInt()))
                .thenReturn(null);

        ResponseEntity<Object> response = assignmentController.getAssignmentByAssessmentId(1);

        Assertions.assertEquals(response,ResponseEntity.badRequest().body("no assignments"));

        // success
        Mockito.when(assignmentService.getAssignmentByAssessmentId(anyInt()))
                .thenReturn(assignmentList);

        ResponseEntity<Object> response2 = assignmentController.getAssignmentByAssessmentId(1);

        Assertions.assertEquals(response2,ResponseEntity.ok().body(assignmentList));

    }

    @Test
    void updateAssignmentById() {

        Assignment assignment = new Assignment(1,"ques","ans", 0.5F);
        AssignmentDao assignmentDao = new AssignmentDao();
        // failure
        Mockito.when(assignmentService.updateAssignmentById(anyInt(),Mockito.any()))
                .thenReturn(null);

        ResponseEntity<Object> response = assignmentController.updateAssignmentById(1,assignmentDao);

        Assertions.assertEquals(response,ResponseEntity.badRequest().body("unable to update assignment"));

        // success

        Mockito.when(assignmentService.updateAssignmentById(anyInt(),Mockito.any()))
                .thenReturn(assignment);

        ResponseEntity<Object> response2 = assignmentController.updateAssignmentById(1,assignmentDao);

        Assertions.assertEquals(response2,ResponseEntity.ok().body(assignment));

    }

    @Test
    void deleteAssignmentById() {

        // failure
        Mockito.when(assignmentService.deleteAssignmentById(anyInt()))
                .thenReturn("unable to delete");

        ResponseEntity<Object> response = assignmentController.deleteAssignmentById(1);

        Assertions.assertEquals(response,ResponseEntity.badRequest().body("unable to delete"));

        // success

        Mockito.when(assignmentService.deleteAssignmentById(anyInt()))
                .thenReturn("assignment deleted");

        ResponseEntity<Object> response2 = assignmentController.deleteAssignmentById(1);

        Assertions.assertEquals(response2,ResponseEntity.ok().body("assignment deleted"));

    }
}