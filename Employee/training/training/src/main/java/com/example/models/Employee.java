package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private String department;
    private double salary;
    private boolean activeStatus;


}
