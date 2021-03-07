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
        @JoinColumn(name = "candidate_id")
        Candidate candidate;

        @ManyToOne
        @JoinColumn(name = "course_id")
        Course course;

        Date createdOnDay = new Date();

        int grade;

        public CandidateCourse(Candidate candidate, Course course) {
                this.candidate = candidate;
                this.course = course;
        }
}
