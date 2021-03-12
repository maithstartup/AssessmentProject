package com.example.AssessmentProject.repository;

import com.example.AssessmentProject.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {
}
