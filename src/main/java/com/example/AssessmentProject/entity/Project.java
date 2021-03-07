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
public class Project {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer projectId;

    Integer assessmentId;

    String title;

    String build;

    String process;

    String testing;

    Float projectScore;

    public Project(Integer assessmentId, String title, String build, String process, String testing, Float projectScore) {
        this.assessmentId = assessmentId;
        this.title = title;
        this.build = build;
        this.process = process;
        this.testing = testing;
        this.projectScore = projectScore;
    }
}
