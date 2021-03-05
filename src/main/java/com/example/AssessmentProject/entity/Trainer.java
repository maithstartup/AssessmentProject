package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Trainer {

    @Id
    Integer trainerId;

    String trainerName;

    String trainerEmail;

    String trainerPassword;

    @OneToMany(mappedBy = "trainerId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Assessment> assessments;
}
