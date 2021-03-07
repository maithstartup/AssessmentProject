package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.AssignmentDao;
import com.example.AssessmentProject.dao.ProjectDoa;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.entity.Project;
import com.example.AssessmentProject.service.AssignmentService;
import com.example.AssessmentProject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Object> addQuiz(@RequestBody ProjectDoa projectDoa){

        Project project = new Project(projectDoa.getAssessmentId(),projectDoa.getTitle(),projectDoa.getBuild(),projectDoa.getProcess(),projectDoa.getTesting(),projectDoa.getProjectScore());
        String response = projectService.addProject(project);

        if(response.equals("project added")){
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
