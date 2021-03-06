package com.example.AssessmentProject.service;

import com.example.AssessmentProject.entity.Quiz;

import java.util.List;

public interface QuizService {

    public String addQuiz(Quiz quiz);

    public Quiz getQuizById(Integer quizId);

    public List<Quiz> getQuizByAssessmentId(Integer assessmentID);

    public Quiz updateQuizById(Integer quizId,Quiz quiz);

    public String deleteQuizById(Integer quizId);

}
