package com.example.AssessmentProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "CandidateAssessment")
@Table(name = "candidate_assessment")
@Setter
@Getter
@NoArgsConstructor
public class CandidateAssessment {

    @EmbeddedId
    private CandidateAssessmentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("candidateId")
    Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("assessmentId")
    Assessment assessment;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    public CandidateAssessment(Candidate candidate, Assessment assessment) {
        this.id = new CandidateAssessmentId(candidate.getCandidateId(), assessment.getAssessmentId());
        this.candidate = candidate;
        this.assessment = assessment;
    }

//Getters and setters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CandidateAssessment that = (CandidateAssessment) o;
        return Objects.equals(candidate, that.candidate) &&
                Objects.equals(assessment, that.assessment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, assessment);
    }
}
