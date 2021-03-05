package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Trainer;
import com.example.AssessmentProject.repository.TrainerRepository;
import com.example.AssessmentProject.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    public String addTrainer(Trainer trainer){

        try {
            trainerRepository.save(trainer);
            return "added";
        }
        catch (Exception e){
            System.out.println(e);
            return "not added";
        }
    }
}
