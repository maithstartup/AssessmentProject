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

    @OneToMany(mappedBy = "courseId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Assessment> assessments;


}
