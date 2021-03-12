package com.example.AssessmentProject.service;

import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.entity.Project;

import java.util.List;

public interface ProjectService {

    public String addProject(Project project);

    public Project getProjectById(Integer projectId);

    public List<Project> getProjectByAssessmentId(Integer assessmentId);

    public Project updateProjectById(Integer assignmentId,Project project);

    public String deleteProjectById(Integer projectId);
}
