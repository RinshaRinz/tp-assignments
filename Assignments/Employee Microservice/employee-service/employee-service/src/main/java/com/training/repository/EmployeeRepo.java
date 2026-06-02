package com.training.repository;

import com.training.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeRepo {
    private Map<Long, Employee> employeeDB = new HashMap<>();
    private Long idCounter = 1L;

    public Employee save(Employee emp) {
        emp.setId(idCounter++);
        employeeDB.put(emp.getId(), emp);
        return emp;
    }

    public Optional<Employee> findById(long id){
       return Optional.ofNullable(employeeDB.get(id));
    }

    public List<Employee> findAll(){
        return new ArrayList<>(employeeDB.values());
    }


    public Employee update(Long id, Employee emp) {
        emp.setId(id);
        employeeDB.put(id, emp);
        return emp;
    }

    public void delete(Long id) {
        employeeDB.remove(id);
    }


}
