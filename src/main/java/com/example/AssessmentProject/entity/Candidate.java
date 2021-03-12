package com.example.AssessmentProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Candidate {

    @Id
    Integer candidateId;

    String candidateName;

    String location;

    String candidateEmail;

    Integer batch;

    @OneToMany(
            mappedBy = "candidate",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CandidateAssessment> assessments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    Set<CandidateCourse> candidateCourses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Candidate candidate = (Candidate) o;
        return Objects.equals(candidateName, candidate.candidateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateName);
    }


    public Candidate(Integer candidateId, String candidateName, String location, String candidateEmail, Integer batch) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.location = location;
        this.candidateEmail = candidateEmail;
        this.batch = batch;
    }
}
