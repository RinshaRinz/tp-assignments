package com.example.employee_service.controller;

import com.example.employee_service.configs.AppConfig;
import com.example.employee_service.dto.Department;
import com.example.employee_service.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {

        long deptId = 11L;

        String url = "http://localhost:8081/department/" + deptId;
        Department dept = restTemplate.getForObject(url, Department.class);


        return new Employee(
                id,
                "Neha",
                dept.getDepartmentName(),
                dept.getLocation(),
                dept.getManagerName()
        );



    }

}
