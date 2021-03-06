package com.example.AssessmentProject.repository;

import com.example.AssessmentProject.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssessmentRepository extends JpaRepository<Assessment,Integer> {

    @Query("SELECT SUM(q.quizScore) FROM Quiz q WHERE q.assessmentId = ?1  GROUP BY q.assessmentId ")
    Float getQuizTotal(Integer assessmentId);

    @Query("SELECT SUM(q.assignmentScore) FROM Assignment q WHERE q.assessmentId = ?1  GROUP BY q.assessmentId ")
    Float getAssignmentTotal(Integer assessmentId);

}
