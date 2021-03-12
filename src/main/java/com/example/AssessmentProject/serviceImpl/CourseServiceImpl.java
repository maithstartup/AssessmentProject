package com.example.AssessmentProject.serviceImpl;

import com.example.AssessmentProject.entity.Candidate;
import com.example.AssessmentProject.entity.Course;
import com.example.AssessmentProject.repository.CourseRepository;
import com.example.AssessmentProject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


   public String addCourse(Course course){

        try {
            courseRepository.save(course);

            return "added";
        }
        catch (Exception e)
        {
            return "not added";
        }

    }

    public Course getCourseById(Integer courseId){
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if(courseOptional.isPresent())
        {
            return courseOptional.get();
        }
        return null;
    }
}
