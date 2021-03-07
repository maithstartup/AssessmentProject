package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.AssignmentDao;
import com.example.AssessmentProject.dao.ProjectDoa;
import com.example.AssessmentProject.entity.Assignment;
import com.example.AssessmentProject.entity.Project;
import com.example.AssessmentProject.service.AssignmentService;
import com.example.AssessmentProject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Object> addQuiz(@RequestBody ProjectDoa projectDao){

        Project project = new Project(projectDao.getAssessmentId(),projectDao.getTitle(),projectDao.getBuild(),projectDao.getProcess(),projectDao.getTesting(),projectDao.getProjectScore());
        String response = projectService.addProject(project);

        if(response.equals("project added")){
            return ResponseEntity.accepted().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/id/{projectId}")
    public ResponseEntity<Object> getAssessmentById(@PathVariable("projectId") Integer projectId){
        Project project = projectService.getProjectById(projectId);
        if(project != null)
            return ResponseEntity.ok().body(project);
        else
            return  ResponseEntity.badRequest().body("no project");

    }

    @GetMapping("/{assessmentId}")
    public ResponseEntity<Object> getProjectByAssessmentId(@PathVariable("assessmentId") Integer assessmentId){
        List<Project> projects = projectService.getProjectByAssessmentId(assessmentId);

        if(projects != null)
            return ResponseEntity.ok().body(projects);
        else
            return  ResponseEntity.badRequest().body("no projects");

    }

    @PutMapping("/id/{projectId}")
    public ResponseEntity<Object> updateProjectById(@PathVariable("projectId") Integer projectId, @RequestBody ProjectDoa projectDao){
        Project project = new Project(projectDao.getAssessmentId(),projectDao.getTitle(),projectDao.getBuild(),projectDao.getProcess(),projectDao.getTesting(),projectDao.getProjectScore());
        Project project1 = projectService.updateProjectById(projectId,project);
        if(project1 != null)
            return ResponseEntity.ok().body(project1);
        else
            return  ResponseEntity.badRequest().body("unable to update project");
    }

    @DeleteMapping("/id/{projectId}")
    public ResponseEntity<Object> deleteProjectById(@PathVariable("projectId") Integer projectId){
        String response = projectService.deleteProjectById(projectId);
        if(response.equals("project deleted"))
            return ResponseEntity.ok().body(response);
        else
            return  ResponseEntity.badRequest().body(response);
    }

}
