package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.dao.CandidateAssessmentDoa;
import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Candidate;
import com.example.AssessmentProject.entity.CandidateAssessment;
import com.example.AssessmentProject.entity.CandidateAssessmentId;
import com.example.AssessmentProject.repository.CandidateRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.CandidateAssessmentService;
import com.example.AssessmentProject.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateAssessmentServiceImpl implements CandidateAssessmentService {


    @Autowired
    CandidateService candidateService;

    @Autowired
    AssessmentService assessmentService;

    @Autowired
    CandidateRepository candidateRepository;

    public String addCandidateAssessment(CandidateAssessmentDoa candidateAssessmentDoa){

        Integer candidateId = candidateAssessmentDoa.getCandidateId();
        Integer assessmentId = candidateAssessmentDoa.getAssessmentId();
        Candidate candidate = candidateService.getCandidateById(candidateId);
        Assessment assessment = assessmentService.getAssessmentById(assessmentId);
        if(candidate != null){

            CandidateAssessment candidateAssessment= new CandidateAssessment(candidate,assessment,candidateAssessmentDoa.getScore());
            List<CandidateAssessment> candidateAssessmentList = candidate.getAssessments();
            candidateAssessmentList.add(candidateAssessment);
            candidate.setAssessments(candidateAssessmentList);
            candidateRepository.save(candidate);
            return "candidate score added";
        }
        return "unable to add candidate score";
    }
}
