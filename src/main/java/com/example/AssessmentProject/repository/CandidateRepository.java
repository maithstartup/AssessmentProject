package com.example.AssessmentProject.repository;

import com.example.AssessmentProject.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
}
