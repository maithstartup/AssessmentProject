package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.repository.AssignmentRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    AssessmentService assessmentService;

    @Autowired
    AssignmentRepository assignmentRepository;

    public String addAssignment(Assignment assignment){
        Integer assessmentId=assignment.getAssessmentId();
        Assessment assessment = assessmentService.getAssessmentById(assessmentId);
        if(assessment != null && assessment.getType().equals("assignment")){

            assignmentRepository.save(assignment);
            return "assignment added";
        }
        return "unable to add assignment";
    }
}
