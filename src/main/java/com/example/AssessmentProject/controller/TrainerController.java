package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.TrainerDao;
import com.example.AssessmentProject.dao.TrainerLoginDao;
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

    @PostMapping("/login")
    public ResponseEntity<Object> addTrainer(@RequestBody TrainerLoginDao trainerLoginDao) {


        Trainer trainer = trainerService.login(trainerLoginDao);

        if (trainer != null) {
            return ResponseEntity.accepted().body(trainer);
        }
        return ResponseEntity.badRequest().body("invalid credentials");
    }

    @PostMapping("/google")
    public ResponseEntity<Object> googleLogin(@RequestBody TrainerLoginDao trainerLoginDao) {


        Trainer trainer = trainerService.googleLogin(trainerLoginDao);

        System.out.println(trainer);
        if (trainer != null) {
            return ResponseEntity.ok().body(trainer);
        }
        return ResponseEntity.badRequest().body("invalid credentials");
    }




}


