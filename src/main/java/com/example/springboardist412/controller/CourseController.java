package com.example.springboardist412.controller;

import com.example.springboardist412.model.Student;
import com.example.springboardist412.repository.StudentRepository;
import com.example.springboardist412.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Controller
@RequestMapping("/courses") // All endpoints in this controller will now start with /courses
public class CourseController {

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    // Changed from /studentList to /courses/studentList
    @GetMapping("/studentList")
    public String viewStudentPage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
        Page<Student> page = studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Student> listStudents = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listStudents", listStudents);

        return "student_list";
    }

    // Changed from /showNewStudentForm to /courses/showNewStudentForm
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/courses/studentList";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id) {
        studentService.deleteStudentById(id);
        return "redirect:/courses/studentList";
    }
}