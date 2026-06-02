package com.training.service;

import com.training.model.Employee;
import com.training.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepo repo;

    public Employee add(Employee emp) {
        return repo.save(emp);
    }

    public Employee findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee update(Long id, Employee emp) {
        return repo.update(id, emp);
    }

    public void delete(Long id) {
        repo.delete(id);
    }


}
