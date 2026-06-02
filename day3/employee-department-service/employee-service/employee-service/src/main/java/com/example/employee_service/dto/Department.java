package com.example.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {

    private Long departmentId;
    private String departmentName;
    private String location;
    private String managerName;

}
