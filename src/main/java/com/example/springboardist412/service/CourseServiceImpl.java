package com.example.springboardist412.service;

import com.example.springboardist412.model.Course;
import com.example.springboardist412.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public Course getCourseById(long id) {
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Course not found for id :: " + id);
        }
    }

    @Override
    public void deleteCourseById(long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public Page<Course> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.courseRepository.findAll(pageable);
    }
}
