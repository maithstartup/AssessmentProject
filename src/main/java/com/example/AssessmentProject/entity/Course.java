package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    Integer courseId;

    String courseDescription;

    Integer preReq;

    Integer trainerId;

    Float courseScore;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "courseId")
    private Set<Assessment> assessments;


    @OneToMany(mappedBy = "course")
    Set<CandidateCourse> candidateCourses;

    public Course(Integer courseId, String courseDescription, Integer preReq, Integer trainerId, Float courseScore) {
        this.courseId = courseId;
        this.courseDescription = courseDescription;
        this.preReq = preReq;
        this.trainerId = trainerId;
        this.courseScore = courseScore;
    }
}
