package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer quizId;

    Integer assessmentId;

    String question;

    String Option_A;

    String Option_B;

    String Option_C;

    String Option_D;

    Integer answer;

    Float quizScore;

}
