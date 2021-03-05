package com.example.AssessmentProject.repository;

import com.example.AssessmentProject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
