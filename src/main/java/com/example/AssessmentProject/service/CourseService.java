package com.example.AssessmentProject.service;

import com.example.AssessmentProject.entity.Candidate;
import com.example.AssessmentProject.entity.Course;

public interface CourseService {

   public String addCourse(Course course);

   public Course getCourseById(Integer courseId);
}
