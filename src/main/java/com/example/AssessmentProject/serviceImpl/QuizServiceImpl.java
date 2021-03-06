package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Quiz;
import com.example.AssessmentProject.repository.QuizRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    AssessmentService assessmentService;

    @Autowired
    QuizRepository quizRepository;

    public String addQuiz(Quiz quiz){

        Integer assessmentId=quiz.getAssessmentId();
        Assessment assessment = assessmentService.getAssessmentById(assessmentId);
        if(assessment != null && assessment.getType().equals("quiz")){


            quizRepository.save(quiz);
            Float score = assessmentService.getScoreByAssessmentId(assessmentId);
            return "quiz added";
        }
        return "unable to add quiz";

    }
    public Quiz getQuizById(Integer quizId){

        Optional<Quiz> quizOptional = quizRepository.findById(quizId);

        if(quizOptional.isPresent())
        {
            return quizOptional.get();
        }
        return null;

    }

    public List<Quiz> getQuizByAssessmentId(Integer assessmentID){

        Assessment assessment = assessmentService.getAssessmentById(assessmentID);

        if(assessment != null)
        {
            List<Quiz> quizList = new ArrayList<>();
            quizList.addAll(assessment.getQuizzes());
            return quizList;
        }
        return null;

    }

    public Quiz updateQuizById(Integer quizId,Quiz quiz){

        Optional<Quiz> quizOptional = quizRepository.findById(quizId);
        if(quizOptional.isPresent())
        {
            Quiz quiz1 = quizOptional.get();

            quiz1.setAnswer(quiz.getAnswer());
            quiz1.setQuizScore(quiz.getQuizScore());
            quiz1.setAssessmentId(quiz.getAssessmentId());
            quiz1.setOptionA(quiz.getOptionA());
            quiz1.setOptionB(quiz.getOptionB());
            quiz1.setOptionC(quiz.getOptionC());
            quiz1.setOptionD(quiz.getOptionD());
            quiz1.setQuizScore(quiz.getQuizScore());

            quizRepository.save(quiz1);
            Float score = assessmentService.getScoreByAssessmentId(quiz.getAssessmentId());
            return quiz1;

        }
        return null;
    }

    public String deleteQuizById(Integer quizId){
        Optional<Quiz> quizOptional = quizRepository.findById(quizId);

        if(quizOptional.isPresent())
        {
            quizRepository.deleteById(quizId);
            Float score = assessmentService.getScoreByAssessmentId(quizOptional.get().getAssessmentId());
            return "quiz deleted";
        }
        return null;
    }

}
