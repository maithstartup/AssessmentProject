package com.example.AssessmentProject.dao;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizDao {


    Integer assessmentId;

    String question;

    String optionA;

    String optionB;

    String optionC;

    String optionD;

    Integer answer;

    Float quizScore;
}
