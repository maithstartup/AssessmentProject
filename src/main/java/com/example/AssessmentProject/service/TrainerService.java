package com.example.AssessmentProject.service;

import com.example.AssessmentProject.dao.TrainerLoginDao;
import com.example.AssessmentProject.entity.Trainer;

public interface TrainerService {

   public String addTrainer(Trainer trainer);

   public Trainer login(TrainerLoginDao trainerLoginDao);

   public Trainer googleLogin(TrainerLoginDao trainerLoginDao);


}
