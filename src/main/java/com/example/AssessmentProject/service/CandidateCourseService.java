package com.example.AssessmentProject.service;

import com.example.AssessmentProject.dao.CandidateCourseDao;

import java.util.List;
import java.util.Map;

public interface CandidateCourseService {
    public String addCandidateCourse(CandidateCourseDao candidateCourseDao);

    public Map<String, List<String>> locationCount(Integer courseId );
}
