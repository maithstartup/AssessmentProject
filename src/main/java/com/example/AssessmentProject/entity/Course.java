package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Course {

    @Id
    Integer courseId;

    String courseDescription;

    Integer preReq;

    Integer trainerId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "courseId")
    private Set<Assessment> assessments;


}
