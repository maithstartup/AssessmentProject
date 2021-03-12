package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Trainer {

    @Id
    Integer trainerId;

    String trainerName;

    String trainerEmail;

    String trainerPassword;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name="trainerId")
    private Set<Assessment> assessments;

    public Trainer(Integer trainerId, String trainerName, String trainerEmail, String trainerPassword) {
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.trainerEmail = trainerEmail;
        this.trainerPassword = trainerPassword;
    }
}
