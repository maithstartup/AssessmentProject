package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.repository.AssessmentRepository;
import com.example.AssessmentProject.service.AssessmentService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Date;

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
}
