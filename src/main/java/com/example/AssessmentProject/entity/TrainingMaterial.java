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
public class TrainingMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer trainingMaterialId;

    Integer assessmentId;

    String trainingMaterialType;

    Byte content;

    public TrainingMaterial(Integer assessmentId, String trainingMaterialType, Byte content) {
        this.assessmentId = assessmentId;
        this.trainingMaterialType = trainingMaterialType;
        this.content = content;
    }
}
