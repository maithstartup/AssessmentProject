package com.example.AssessmentProject.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssessmentDao {

    String assessmentName;

    String type;

    float score;

    String description;

    int courseId;

    int trainerId;
}
