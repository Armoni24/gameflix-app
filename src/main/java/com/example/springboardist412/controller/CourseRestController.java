package com.example.springboardist412.controller;

import com.example.springboardist412.model.Course;
import com.example.springboardist412.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course/", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
