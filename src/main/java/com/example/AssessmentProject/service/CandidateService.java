package com.example.AssessmentProject.service;

import com.example.AssessmentProject.entity.Candidate;
import com.example.AssessmentProject.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CandidateService {

    public Candidate getCandidateById(Integer candidateId);

    public String addCandidate(Candidate candidate);
}
