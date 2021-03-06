package com.example.AssessmentProject.service;

import com.example.AssessmentProject.entity.Assessment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface AssessmentService {

   public String addAssessment(Assessment assessment);

   public Assessment getAssessmentById(Integer assessmentId);

   public List<Assessment> getAllAssessment();

   public Assessment updateAssessmentById(Integer assessmentId,Assessment assessment);

   public String deleteAssessmentById(Integer assessmentId);


}