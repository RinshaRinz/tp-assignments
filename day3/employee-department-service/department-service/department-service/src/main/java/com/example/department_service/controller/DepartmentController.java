package com.example.department_service.controller;

import com.example.department_service.dto.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id){

        return new Department(
                id,
                "Engineering",
                "Bangalore",
                "Suresh" // BONUS: managerName
        );


    }
}
