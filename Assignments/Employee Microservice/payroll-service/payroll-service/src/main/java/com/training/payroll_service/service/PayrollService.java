package com.training.payroll_service.service;

import org.springframework.stereotype.Service;

@Service
public class PayrollService {

    public double calculateSalary(double baseSalary) {
        double bonus = baseSalary * 0.2;
        return baseSalary + bonus;
    }

    public double calculateTax(double salary) {
        return salary * 0.1;
    }

    public String generatePayslip(double salary) {
        double tax = calculateTax(salary);
        double netSalary = salary - tax;

        return "Salary: " + salary +
                ", Tax: " + tax +
                ", Net Salary: " + netSalary;
    }


}
