package com.example.AssessmentProject.repository;

import com.example.AssessmentProject.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer,Integer> {

    public Optional<Trainer> findTrainerByTrainerEmail(String s);
}
