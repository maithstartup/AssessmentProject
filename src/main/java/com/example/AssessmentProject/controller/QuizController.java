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
            return  ResponseEntity.badRequest().body("no quiz");

    }

    @GetMapping("/{assessmentId}")
    public ResponseEntity<Object> getQuizByAssessmentId(@PathVariable("assessmentId") Integer assessmentId){
        List<Quiz> quizzes = quizService.getQuizByAssessmentId(assessmentId);

        if(quizzes != null)
            return ResponseEntity.ok().body(quizzes);
        else
            return  ResponseEntity.badRequest().body("no quizzes");

    }

    @PutMapping("/id/{quizId}")
    public ResponseEntity<Object> updateQuizById(@PathVariable("quizId") Integer quizId, @RequestBody QuizDao quizDao){
        Quiz quiz = new Quiz(quizDao.getAssessmentId(),quizDao.getQuestion(),quizDao.getOptionA(),quizDao.getOptionB(),quizDao.getOptionC(),quizDao.getOptionD(),quizDao.getAnswer(),quizDao.getQuizScore());
        Quiz quiz1 = quizService.updateQuizById(quizId,quiz);
        if(quiz1 != null)
            return ResponseEntity.ok().body(quiz1);
        else
            return  ResponseEntity.badRequest().body("unable to update quiz");
    }

    @DeleteMapping("/id/{quizId}")
    public ResponseEntity<Object> deleteQuizById(@PathVariable("quizId") Integer quizId){
        String response = quizService.deleteQuizById(quizId);
        if(response.equals("quiz deleted"))
            return ResponseEntity.ok().body(response);
        else
            return  ResponseEntity.badRequest().body(response);
    }

}
