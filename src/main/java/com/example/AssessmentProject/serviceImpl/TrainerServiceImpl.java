package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.dao.TrainerLoginDao;
import com.example.AssessmentProject.entity.Trainer;
import com.example.AssessmentProject.repository.TrainerRepository;
import com.example.AssessmentProject.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Trainer login(TrainerLoginDao trainerLoginDao){

        Optional<Trainer> trainerOptional = trainerRepository.findTrainerByTrainerEmail(trainerLoginDao.getTrainerEmail());

        if(trainerOptional.isPresent())
        {
            Trainer trainer = trainerOptional.get();
            System.out.println(trainer.getTrainerId());
           if(trainer.getTrainerPassword().equals(trainerLoginDao.getTrainerPassword()))
               return trainer;
        }
        return  null;
    }

    @Override
    public Trainer googleLogin(TrainerLoginDao trainerLoginDao) {

        Optional<Trainer> trainerOptional = trainerRepository.findTrainerByTrainerEmail(trainerLoginDao.getTrainerEmail());
        if(trainerOptional.isPresent())
        {
            Trainer trainer = trainerOptional.get();
            System.out.println(trainer.getTrainerId());
                return trainer;
        }
        return  null;
    }
}
