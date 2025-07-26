package com.example.springboardist412.model; // ✅ Adjust this to match your actual package name

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dept", nullable = false)
    private String courseDept;

    @Column(name = "num", nullable = false)
    private String courseNum;

    @Column(name = "name", nullable = false)
    private String courseName;

    @Column(name = "num_studs")
    private String courseStuds;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

    // Constructors
    public Course() {}

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseDept() {
        return courseDept;
    }

    public void setCourseDept(String courseDept) {
        this.courseDept = courseDept;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseStuds() {
        return courseStuds;
    }

    public void setCourseStuds(String courseStuds) {
        this.courseStuds = courseStuds;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}