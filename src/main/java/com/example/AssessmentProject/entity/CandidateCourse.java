package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CandidateCourse {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer candidateCourseId;

        @ManyToOne
        @JoinColumn(name = "candidateId")
        Candidate candidate;

        @ManyToOne
        @JoinColumn(name = "courseId")
        Course course;

        Date createdOnDay = new Date();

        Float score;

        public CandidateCourse(Candidate candidate, Course course,Float score) {
                this.candidate = candidate;
                this.course = course;
                this.score = score;
        }
}
