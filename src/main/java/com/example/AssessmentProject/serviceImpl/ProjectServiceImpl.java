package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;

import com.example.AssessmentProject.entity.Project;
import com.example.AssessmentProject.repository.ProjectRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Project getProjectById(Integer projectId){
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if(projectOptional.isPresent())
        {
            return projectOptional.get();
        }
        return null;
    }

    public List<Project> getProjectByAssessmentId(Integer assessmentID){

        Assessment assessment = assessmentService.getAssessmentById(assessmentID);

        if(assessment != null)
        {
            List<Project> projectList = new ArrayList<>();
            projectList.addAll(assessment.getProjects());
            return projectList;
        }
        return null;

    }

    public Project updateProjectById(Integer projectId,Project project){

        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if(projectOptional.isPresent())
        {
            Project project1 = projectOptional.get();

            project1.setTitle(project.getTitle());
            project1.setProjectScore(project.getProjectScore());
            project1.setAssessmentId(project.getAssessmentId());
            project1.setBuild(project.getBuild());
            project1.setProcess(project.getProcess());
            project1.setTesting(project.getTesting());


            projectRepository.save(project1);
            assessmentService.getScoreByAssessmentId(project.getAssessmentId());
            return project1;

        }
        return null;
    }

    public String deleteProjectById(Integer projectId){
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if(projectOptional.isPresent())
        {
            projectRepository.deleteById(projectId);
            assessmentService.getScoreByAssessmentId(projectOptional.get().getAssessmentId());
            return "project deleted";
        }
        return null;
    }

}
