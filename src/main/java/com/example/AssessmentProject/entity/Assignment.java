package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Getter
@Setter
public class Assignment {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer assignmentId;

    Integer assessmentId;

    String question;

    String answer;

    Float assignmentScore;


}
