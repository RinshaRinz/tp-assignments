package com.example.training;

import com.example.Results.EmployeeResults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
        EmployeeResults emp = new EmployeeResults();
        emp.getResults();

	}

}
