package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.repository.AssignmentRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            assessmentService.getScoreByAssessmentId(assessmentId);
            return "assignment added";
        }
        return "unable to add assignment";
    }

    public Assignment getAssignmentById(Integer assignmentId){
        Optional<Assignment> assignmentOptional = assignmentRepository.findById(assignmentId);

        if(assignmentOptional.isPresent())
        {
            return assignmentOptional.get();
        }
        return null;
    }

    public List<Assignment> getAssignmentByAssessmentId(Integer assessmentID){

        Assessment assessment = assessmentService.getAssessmentById(assessmentID);

        if(assessment != null)
        {
            List<Assignment> assignmentList = new ArrayList<>();
            assignmentList.addAll(assessment.getAssignments());
            return assignmentList;
        }
        return null;

    }

    public Assignment updateAssignmentById(Integer assignmentId,Assignment assignment){

        Optional<Assignment> assignmentOptional = assignmentRepository.findById(assignmentId);
        if(assignmentOptional.isPresent())
        {
            Assignment assignment1 = assignmentOptional.get();

            assignment1.setAnswer(assignment.getAnswer());
            assignment1.setAssignmentScore(assignment.getAssignmentScore());
            assignment1.setAssessmentId(assignment.getAssessmentId());
            assignment1.setQuestion(assignment.getQuestion());

            assignmentRepository.save(assignment1);
            Float score = assessmentService.getScoreByAssessmentId(assignment.getAssessmentId());
            return assignment1;

        }
        return null;
    }

    public String deleteAssignmentById(Integer assignmentId){
        Optional<Assignment> assignmentOptional = assignmentRepository.findById(assignmentId);

        if(assignmentOptional.isPresent())
        {
            assignmentRepository.deleteById(assignmentId);
            assessmentService.getScoreByAssessmentId(assignmentOptional.get().getAssessmentId());
            return "assignment deleted";
        }
        return null;
    }

}
