package com.example.student_mgmt.controller;

import com.example.student_mgmt.models.Student;
import com.example.student_mgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student st, @PathVariable Long id) {
        return service.updateStudent(st,id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        return service.deleteStudentById(id);
    }



}
