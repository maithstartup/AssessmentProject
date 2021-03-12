package com.example.AssessmentProject.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class CandidateAssessmentId
        implements Serializable {

    @Column(name = "candidate_id")
    private Integer candidateId;

    @Column(name = "assessment_id")
    private Integer assessmentId;

    public CandidateAssessmentId(Integer candidateId, Integer assessmentId) {
        this.candidateId = candidateId;
        this.assessmentId = assessmentId;
    }


//Getters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CandidateAssessmentId that = (CandidateAssessmentId) o;
        return Objects.equals(candidateId, that.candidateId) &&
                Objects.equals(assessmentId, that.assessmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId, assessmentId);
    }
}
