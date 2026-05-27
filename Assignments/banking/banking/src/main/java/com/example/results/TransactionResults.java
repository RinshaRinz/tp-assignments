package com.example.results;

import com.example.model.Transaction;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionResults {
    List<Transaction> transactions = new ArrayList<>();

    public TransactionResults() {
       transactions = Arrays.asList(
                new Transaction("012", "1001", "DEBIT", 2500.00, LocalDate.of(2026, 5, 20)),
                new Transaction("098", "1003", "CREDIT", 500000.00, LocalDate.of(2026, 5, 21)),
                new Transaction("0098", "2008", "DEBIT", 1200.50, LocalDate.of(2026, 5, 22)),
                new Transaction("00982", "20308", "DEBIT", 1200.50, LocalDate.of(2026, 5, 22)),
                new Transaction("234", "2020", "CREDIT", 3000.75, LocalDate.of(2026, 5, 23)),
                new Transaction("456", "2012", "DEBIT", 700.00, LocalDate.of(2026, 5, 24)));
    }

    public void getResults() {

//        1.	Find all debit transactions
        System.out.println("1.\tFind all debit transactions ");
        transactions.stream()
                .filter(t -> t.getTransactionType().equalsIgnoreCase("DEBIT"))
                .forEach(t -> System.out.println(t.getAccountNumber() + ": " + t.getAmount()));

//        2.	Find transactions above ₹50,000
        System.out.println("2.\tFind transactions above ₹50,000 ");
        transactions.stream().filter(t -> t.getAmount()> 50000).forEach(t -> System.out.println(t.getAmount()));

//        3.	Calculate total credited amount
        System.out.println("3.\tCalculate total credited amount");
        System.out.println(transactions.stream().mapToDouble(Transaction::getAmount).sum());

//        4.	Group transactions by type
        System.out.println("3.\tGroup transactions by type");
        System.out.println(transactions.stream().collect(Collectors.groupingBy(Transaction::getTransactionType,Collectors.counting())));

//        5.	Find latest transaction
        System.out.println("5.\tFind latest transaction ");
        transactions.stream().sorted(Comparator.comparing(Transaction::getTransactionDate).reversed())
                .forEach(t -> System.out.println(t.getAmount()));

//        6.	Sort transactions by amount descending

        System.out.println("6.\tSort transactions by amount descending ");
        transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .forEach(t -> System.out.println(t.getAmount()));

//        7.	Use Parallel Stream for processing
        System.out.println("7.\tSort transactions by amount descending using parallel stream");
        transactions.parallelStream().sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .forEachOrdered(t -> System.out.println(t.getAmount()));

//        8.	Fraud suspicious transactions
        System.out.println("7.\tFraud suspicious transactions");
        transactions.parallelStream()
                .filter(t -> t.getAmount() > 100000)
                .forEach(t -> System.out.println("Suspicious: " + t.getAccountNumber()));

        //•	Duplicate transaction amounts
        System.out.println("•\tDuplicate transaction amounts ");
        Map<Double,Long>map  = transactions.stream().
                collect(Collectors.groupingBy(Transaction::getAmount,Collectors.counting()));
        map.entrySet().stream().filter(e -> e.getValue()>1)
                .forEach(t -> System.out.println("Suspicious: " + t.getKey()));

//        •	Top 5 highest transactions
        System.out.println("•\tTop 5 highest transactions");
       transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()).limit(5)
                .forEach(t -> System.out.println(t.getAmount()));
        ;



    }

}
