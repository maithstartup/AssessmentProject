package com.example.AssessmentProject.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @OneToMany(cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
    @JoinColumn(name = "assessmentId")
    Set<Quiz> quizzes;

    @OneToMany(cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
    @JoinColumn(name = "assessmentId")
    Set<Assignment> assignments;

    public Assessment(String assessmentName, String type, float score, String description, int courseId, int trainerId) {
        this.assessmentName = assessmentName;
        this.type = type;
        this.score = score;
        this.description = description;
        this.courseId = courseId;
        this.trainerId = trainerId;
    }
}
