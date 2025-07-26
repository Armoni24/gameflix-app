package com.example.springboardist412.repository;

import com.example.springboardist412.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long id); // Optional override (JpaRepository already provides this)
}