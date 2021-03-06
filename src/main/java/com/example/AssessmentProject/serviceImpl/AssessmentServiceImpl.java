package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.TrainingMaterial;
import com.example.AssessmentProject.repository.AssessmentRepository;
import com.example.AssessmentProject.service.AssessmentService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    AssessmentRepository assessmentRepository;

    public String addAssessment(Assessment assessment){
        try {

            Date date = new Date();
            assessment.setLastUpdate(date);

            assessmentRepository.save(assessment);
            return "added";
        }
        catch (Exception e)
        {
            return "unable to add";
        }

    }
    public Assessment getAssessmentById(Integer assessmentId){

        Optional<Assessment> assessmentOptional = assessmentRepository.findById(assessmentId);

        if(assessmentOptional.isPresent())
        {
            return assessmentOptional.get();
        }
        return null;

    }

    public List<Assessment> getAllAssessment(){
        List<Assessment> assessments = assessmentRepository.findAll();
        if(assessments.size()!=0){
            return assessments;
        }
        return null;
    }

    public Assessment updateAssessmentById(Integer assessmentId,Assessment assessment){
       Optional<Assessment> assessmentOptional = assessmentRepository.findById(assessmentId);
       if(assessmentOptional.isPresent())
       {
          Assessment assessment1 = assessmentOptional.get();
          if(assessment1.getType().equals(assessment.getType()))
            {
                assessment1.setAssessmentName(assessment.getAssessmentName());
                assessment1.setDescription(assessment.getDescription());
                assessment1.setCourseId(assessment.getCourseId());
                Date date = new Date();
                assessment1.setLastUpdate(date);
                assessmentRepository.save(assessment1);
              return assessment1;
            }
       }
       return null;
    }

    public String deleteAssessmentById(Integer assessmentId){

        Optional<Assessment> assessmentOptional = assessmentRepository.findById(assessmentId);

        if(assessmentOptional.isPresent())
        {
            assessmentRepository.deleteById(assessmentId);
            return "assessment deleted";
        }
        return null;
    }

    public Float getScoreByAssessmentId(Integer assessmentId){


        Assessment assessment = getAssessmentById(assessmentId);
        Float totalScore= Float.valueOf(0);
        if(assessment != null)
        {
            if(assessment.getType().equals("quiz"))
            {
                totalScore = assessmentRepository.getQuizTotal(assessmentId);
            }
            else if(assessment.getType().equals("assignment"))
            {
                totalScore = assessmentRepository.getAssignmentTotal(assessmentId);
            }

        }
        assessment.setScore(totalScore);
        assessmentRepository.save(assessment);
        return totalScore;
    }




}
