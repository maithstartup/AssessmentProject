package com.example.AssessmentProject.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer assessmentId;

    String assessmentName;

    String type;

    float score;

    String description;

    Integer courseId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    int trainerId;

    public Assessment(String assessmentName, String type, float score, String description, int courseId, int trainerId) {
        this.assessmentName = assessmentName;
        this.type = type;
        this.score = score;
        this.description = description;
        this.courseId = courseId;
        this.trainerId = trainerId;
    }
}
