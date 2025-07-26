package com.example.springboardist412.service; // Adjust to match your project structure

import com.example.springboardist412.model.Course;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    void saveCourse(Course course);
    Course getCourseById(long id);
    void deleteCourseById(long id);
    Page<Course> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
