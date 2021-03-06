package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.TrainerDao;
import com.example.AssessmentProject.entity.Trainer;
import com.example.AssessmentProject.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PostMapping("")
    public ResponseEntity<Object> addTrainer(@RequestBody TrainerDao trainerDao) {

        Trainer trainer = new Trainer(trainerDao.getTrainerId(), trainerDao.getTrainerName(), trainerDao.getTrainerEmail(), trainerDao.getTrainerPassword());
        String response = trainerService.addTrainer(trainer);

        if (response.equals("added")) {
            return ResponseEntity.accepted().body("added");
        }
        return ResponseEntity.badRequest().body("not added");
    }

}

