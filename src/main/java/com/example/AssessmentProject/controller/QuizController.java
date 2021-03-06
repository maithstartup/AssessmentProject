package com.example.AssessmentProject.controller;


import com.example.AssessmentProject.dao.AssessmentDao;
import com.example.AssessmentProject.dao.QuizDao;
import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Quiz;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("")
    public ResponseEntity<Object> addQuiz(@RequestBody QuizDao quizDao){

        Quiz quiz = new Quiz(quizDao.getAssessmentId(),quizDao.getQuestion(),quizDao.getOptionA(),quizDao.getOptionB(),quizDao.getOptionC(),quizDao.getOptionD(),quizDao.getAnswer(),quizDao.getQuizScore());
        String response = quizService.addQuiz(quiz);

        if(response.equals("quiz added")){
            return ResponseEntity.accepted().body("quiz added");
        }
        return ResponseEntity.badRequest().body("unable to add quiz");
    }

    @GetMapping("/id/{quizId}")
    public ResponseEntity<Object> getAssessmentById(@PathVariable("quizId") Integer quizId){
        Quiz quiz = quizService.getQuizById(quizId);
        if(quiz != null)
            return ResponseEntity.ok().body(quiz);
        else
            return  ResponseEntity.badRequest().body("no assessment");

    }

    @GetMapping("")
    public ResponseEntity<Object> getAllAssessment(){
        List<Assessment> assessment = assessmentService.getAllAssessment();
        if(assessment != null)
            return ResponseEntity.ok().body(assessment);
        else
            return  ResponseEntity.badRequest().body("no assessment");

    }

    @PutMapping("/id/{assessmentId}")
    public ResponseEntity<Object> updateAssessmentById(@PathVariable("assessmentId") Integer assessmentId, @RequestBody AssessmentDao assessmentDao){
        Assessment assessment = new Assessment(assessmentDao.getAssessmentName(), assessmentDao.getType(),assessmentDao.getScore(),assessmentDao.getDescription(), assessmentDao.getCourseId(),assessmentDao.getTrainerId());
        Assessment assessment1 = assessmentService.updateAssessmentById(assessmentId,assessment);
        if(assessment1 != null)
            return ResponseEntity.ok().body(assessment1);
        else
            return  ResponseEntity.badRequest().body("unable to update assessment");
    }

    @DeleteMapping("/id/{assessmentId}")
    public ResponseEntity<Object> deleteAssessmentById(@PathVariable("assessmentId") Integer assessmentId){
        String response = assessmentService.deleteAssessmentById(assessmentId);

        if(response.equals("assessment deleted"))
            return ResponseEntity.ok().body(response);
        else
            return  ResponseEntity.badRequest().body(response);
    }




}
