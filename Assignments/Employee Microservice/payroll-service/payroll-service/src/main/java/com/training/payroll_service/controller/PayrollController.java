package com.training.payroll_service.controller;

import com.training.payroll_service.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService service;

    // Calculate Salary
    @GetMapping("/salary")
    public double getSalary(@RequestParam double base) {
        return service.calculateSalary(base);
    }

    // Calculate Tax
    @GetMapping("/tax")
    public double getTax(@RequestParam double salary) {
        return service.calculateTax(salary);
    }

    // Generate Payslip
    @GetMapping("/payslip")
    public String getPayslip(@RequestParam double salary) {
        return service.generatePayslip(salary);
    }

}
