package com.example.AssessmentProject.controller;

import com.example.AssessmentProject.dao.AssessmentDao;
import com.example.AssessmentProject.dao.CourseDao;
import com.example.AssessmentProject.entity.Assessment;
import com.example.AssessmentProject.entity.Course;
import com.example.AssessmentProject.service.AssessmentService;
import com.example.AssessmentProject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("")
    public ResponseEntity<Object> addCourse(@RequestBody CourseDao courseDao){

        Course course = new Course(courseDao.getCourseId(),courseDao.getCourseDescription(),courseDao.getPreReq(),courseDao.getTrainerId(), courseDao.getCourseScore());
        String response = courseService.addCourse(course);

        if(response.equals("added")){
            return ResponseEntity.accepted().body("added");
        }
        return ResponseEntity.badRequest().body("not added");
    }

}
