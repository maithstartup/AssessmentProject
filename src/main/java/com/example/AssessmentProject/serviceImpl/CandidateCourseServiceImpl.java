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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CandidateCourseServiceImpl implements CandidateCourseService {

    @Autowired
    CandidateService candidateService;

    @Autowired
    CourseService courseService;

    @Autowired
    CandidateCourseRepository candidateCourseRepository;

    public String addCandidateCourse(CandidateCourseDao candidateCourseDao) {

        Candidate candidate = candidateService.getCandidateById(candidateCourseDao.getCandidateId());
        Course course = courseService.getCourseById(candidateCourseDao.getCourseId());
        CandidateCourse candidateCourse = new CandidateCourse(candidate, course, candidateCourseDao.getScore());
        System.out.println(candidateCourse);
        if (candidate != null && course != null) {
            try {
                candidateCourseRepository.save(candidateCourse);
                return "added";
            } catch (Exception e) {
                System.out.println(e);
                return "not added";
            }

        }
        return "not added";


    }
//    public List<Map<String,Integer>> locationCount(Integer courseId ){
//        System.out.println("hey");
//        List<Map<String,Integer>> response= candidateCourseRepository.locationCount(5);
//        System.out.println(response.size());
//        for(Map<String,Integer> temp:response)
//        {
//            System.out.println(temp.keySet());
//            System.out.println(temp.values());
//
//        }
//        return response;
//    }

    public Map<String, List<String>> locationCount(Integer assessId ){
        List<String> response =  candidateCourseRepository.locationCount(assessId);

        Map<String, List<String>> responseMap = new HashMap<>();
        List<String> location = new ArrayList<>();
        List<String> count = new ArrayList<>();
        for(String s: response){
            String[] str = s.split(",");
            location.add(str[0]);
            count.add(str[1]);
        }
        responseMap.put("location", location);
        responseMap.put("count", count);

        return responseMap;
    }
}
