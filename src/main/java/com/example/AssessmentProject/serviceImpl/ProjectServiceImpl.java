package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.entity.Project;
import com.example.AssessmentProject.repository.AssignmentRepository;
import com.example.AssessmentProject.repository.ProjectRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    AssessmentService assessmentService;

    @Autowired
    ProjectRepository projectRepository;

    public String addProject(Project project){
        Integer assessmentId=project.getAssessmentId();
        Assessment assessment = assessmentService.getAssessmentById(assessmentId);
        if(assessment != null && assessment.getType().equals("project")){

            projectRepository.save(project);
            assessmentService.getScoreByAssessmentId(assessmentId);
            return "project added";
        }
        return "unable to add project";
    }
}
