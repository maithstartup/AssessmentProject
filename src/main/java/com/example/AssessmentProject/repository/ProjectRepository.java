package com.example.AssessmentProject.repository;

import com.example.AssessmentProject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
