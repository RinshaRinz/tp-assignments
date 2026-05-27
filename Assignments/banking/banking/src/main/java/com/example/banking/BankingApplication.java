package com.example.banking;

import com.example.banking.results.TransactionResults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
        TransactionResults t = new TransactionResults();
        t.getResults();
	}

}
