package com.example.student_mgmt.service;

import com.example.student_mgmt.models.Student;
import com.example.student_mgmt.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;


    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student, Long id) {
        Student st = repository.findById(id).orElse(null);
        if (st != null) {
            st.setName(student.getName());
            st.setMarks(student.getMarks());
            st.setCourse(student.getCourse());
            repository.save(st);
            return st;
        }
        return null;
    }

    public String deleteStudentById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Student deleted successfully";
        }
        return "Student not found";

    }

}
