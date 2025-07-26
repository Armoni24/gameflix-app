package com.example.springboardist412.repository; // Adjust if needed

import com.example.springboardist412.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findBySid(Long sid); // Use your entity’s field name (sid)
}