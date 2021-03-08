package com.example.AssessmentProject.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDao {

    Integer courseId;

    String courseDescription;

    Integer preReq;

    Integer trainerId;

    Float courseScore;
}
