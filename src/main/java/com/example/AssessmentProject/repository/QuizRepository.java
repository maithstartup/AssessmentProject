package com.example.AssessmentProject.repository;

import com.example.AssessmentProject.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
}
