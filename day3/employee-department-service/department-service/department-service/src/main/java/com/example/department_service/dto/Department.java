package com.example.department_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Long departmentId;
    private String departmentName;
    private String location;
    private String managerName;


}
