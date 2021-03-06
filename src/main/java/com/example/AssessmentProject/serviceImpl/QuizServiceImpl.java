package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Quiz;
import com.example.AssessmentProject.repository.QuizRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    AssessmentService assessmentService;

    @Autowired
    QuizRepository quizRepository;

    public String addQuiz(Quiz quiz){

        Integer assessmentId=quiz.getAssessmentId();
        Assessment assessment = assessmentService.getAssessmentById(assessmentId);
        if(assessment != null && assessment.getType().equals("quiz")){

            quizRepository.save(quiz);
            return "quiz added";
        }
        return "unable to add quiz";

    }
}
