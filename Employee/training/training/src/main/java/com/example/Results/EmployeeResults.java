package com.example.Results;

import com.example.models.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeResults {

    List<Employee> employees = new ArrayList<>();


    public EmployeeResults() {
        employees.add(new Employee(1L, "Arjun", "HR", 50000, true));
        employees.add(new Employee(2L, "Brinnie", "IT", 70000, true));
        employees.add(new Employee(3L, "Kevin", "Finance", 65000, false));
        employees.add(new Employee(4L, "Fred", "Marketing", 55000, true));
        employees.add(new Employee(5L, "Neha", "Sales", 60000, false));
    }


    public void getResults() {
//        1.	Fetch employees with salary > 60,000
        System.out.println("-------------------1.Fetch employees with salary > 60,000----------------");
        employees.stream().filter(emp -> emp.getSalary() > 60000).
                forEach(emp -> System.out.println(emp.getName()));

        System.out.println();
        System.out.println();
        System.out.println();

//        2.	Convert employee names to uppercase
        System.out.println("-------------------2.Convert employee names to uppercase----------------");
        employees.stream().map(emp -> emp.getName().toUpperCase()).
                forEach(System.out::println);

        System.out.println();
        System.out.println();
        System.out.println();

//        3.	Sort employees by salary descending
        System.out.println("3.Sort employees by salary descending ");
        employees.stream().
                sorted((emp1, emp2) -> (int) (emp2.getSalary() - emp1.getSalary()))
                .forEach(emp -> System.out.println(emp.getName()));

        System.out.println();
        System.out.println();
        System.out.println();

//        4.	Find count of active employees
        System.out.println("Find count of active employees ");
        employees.stream().filter(Employee::isActiveStatus).
                forEach(emp -> System.out.println(emp.getName()));

        System.out.println();
        System.out.println();
        System.out.println();

        //    5.	Group employees department-wise
        System.out.println("Group employees department-wise");
        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy((Employee::getDepartment), Collectors.counting()));
        System.out.println(collect);

        System.out.println();
        System.out.println();
        System.out.println();

//        6.	Find highest salary employee
        System.out.println("Find highest salary employee");
        employees.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(emp -> System.out.println(emp.getName()));


        System.out.println();
        System.out.println();
        System.out.println();

//        7.	Find second highest salary employee
        System.out.println("Find second highest salary employee");
        employees.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
                .limit(2).skip(1).forEach(emp -> System.out.println(emp.getName()));

    }


}
