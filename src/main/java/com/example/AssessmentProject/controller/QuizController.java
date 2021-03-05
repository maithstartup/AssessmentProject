package com.example.AssessmentProject.controller;


import com.example.AssessmentProject.dao.AssessmentDao;
import com.example.AssessmentProject.dao.QuizDao;
import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Quiz;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
