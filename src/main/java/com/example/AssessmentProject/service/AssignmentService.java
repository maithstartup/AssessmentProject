package com.example.AssessmentProject.service;

import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.entity.Quiz;

import java.util.List;

public interface AssignmentService {

    public String addAssignment(Assignment assignment);

    public Assignment getAssignmentById(Integer assignmentId);

    public List<Assignment> getAssignmentByAssessmentId(Integer assessmentID);

    public Assignment updateAssignmentById(Integer assignmentId,Assignment assignment);

    public String deleteAssignmentById(Integer AssignmentId);
}
