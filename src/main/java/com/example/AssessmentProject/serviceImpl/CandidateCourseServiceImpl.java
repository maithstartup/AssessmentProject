package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.dao.CandidateCourseDao;
import com.example.AssessmentProject.entity.Candidate;
import com.example.AssessmentProject.entity.CandidateCourse;
import com.example.AssessmentProject.entity.Course;
import com.example.AssessmentProject.repository.CandidateCourseRepository;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.CandidateCourseService;
import com.example.AssessmentProject.service.CandidateService;
import com.example.AssessmentProject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateCourseServiceImpl implements CandidateCourseService {

    @Autowired
    CandidateService candidateService;

    @Autowired
    CourseService courseService;

    @Autowired
    CandidateCourseRepository candidateCourseRepository;

    public String addCandidateCourse(CandidateCourseDao candidateCourseDao){

        Candidate candidate = candidateService.getCandidateById(candidateCourseDao.getCandidateId());
        Course course = courseService.getCourseById(candidateCourseDao.getCourseId());
        CandidateCourse candidateCourse = new CandidateCourse(candidate,course);
        System.out.println(candidateCourse);
        try {
            candidateCourseRepository.save(candidateCourse);

            return "added";
        }
        catch (Exception e){
            System.out.println(e);
            return "not added";
        }

    }
}
