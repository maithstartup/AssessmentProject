package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer quizId;

    Integer assessmentId;

    String question;

    String optionA;

    String optionB;

    String optionC;

    String optionD;

    Integer answer;

    Float quizScore;

    public Quiz(Integer assessmentId, String question, String optionA, String optionB, String optionC, String optionD, Integer answer, Float quizScore) {
        this.assessmentId = assessmentId;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.quizScore = quizScore;
    }
}
