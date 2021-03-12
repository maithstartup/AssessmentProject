package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Candidate;
import com.example.AssessmentProject.repository.CandidateRepository;
import com.example.AssessmentProject.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public Candidate getCandidateById(Integer candidateId){

       Optional<Candidate> candidateOptional = candidateRepository.findById(candidateId);
       if(candidateOptional.isPresent())
       {
           return candidateOptional.get();
       }
       return null;
    }
    public String addCandidate(Candidate candidate){

        try {
            candidateRepository.save(candidate);
            return "added";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "unable to add";
        }
    }
}
