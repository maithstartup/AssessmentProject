package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.AssignmentDao;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.AssignmentService;
import com.example.AssessmentProject.serviceImpl.AssignmentServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mockConstruction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

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

        Mockito.when(assignmentService.getAssignmentById(Mockito.any()))
                .thenReturn(null);

        ResponseEntity<Object> response = assignmentController.getAssignmentById(Mockito.any());


        Assertions.assertEquals(response,ResponseEntity.badRequest().body("no assignment"));

        Mockito.when(assignmentService.getAssignmentById(Mockito.any()))
                .thenReturn(assignment);

        ResponseEntity<Object> response2 = assignmentController.getAssignmentById(Mockito.any());
        Assertions.assertEquals(response2,ResponseEntity.ok().body(assignment));

    }

    @Test
    void getAssignmentByAssessmentId() {
    }

    @Test
    void updateAssignmentById() {
    }

    @Test
    void deleteAssignmentById() {
    }
}