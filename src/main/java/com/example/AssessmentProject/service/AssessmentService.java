package com.example.AssessmentProject.service;

import com.example.AssessmentProject.entity.Assessment;
import org.springframework.http.ResponseEntity;

public interface AssessmentService {

   public String addAssessment(Assessment assessment);

   public Assessment getAssessmentById(Integer assessmentId);


}
