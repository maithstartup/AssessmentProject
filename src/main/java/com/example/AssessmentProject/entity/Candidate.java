package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Candidate {

    @Id
    Integer candidateId;

    String candidateName;

    String location;

    String candidateEmail;

    Integer batch;
}
