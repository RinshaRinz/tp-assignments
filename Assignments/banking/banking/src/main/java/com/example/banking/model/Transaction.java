package com.example.banking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Transaction {


    private String transactionId;
    private String accountNumber;
    private String transactionType;
    private double amount;
    private LocalDate transactionDate;


}
