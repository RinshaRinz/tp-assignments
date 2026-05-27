package com.training.payroll_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class PayrollServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(PayrollServiceApplication.class, args);
	}

}
