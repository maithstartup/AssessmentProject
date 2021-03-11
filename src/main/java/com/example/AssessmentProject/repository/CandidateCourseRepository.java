package com.example.AssessmentProject.repository;

import com.example.AssessmentProject.entity.CandidateCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CandidateCourseRepository extends JpaRepository<CandidateCourse,Integer> {

    @Query("SELECT c.candidate.location,COUNT(*) FROM CandidateCourse c WHERE c.course.courseId = ?1  GROUP BY c.candidate.location ")
    List<Map<String,Integer>> locationCount(Integer courseId);

}
