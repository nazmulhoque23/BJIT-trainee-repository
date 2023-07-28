package com.example.reactivedemo.webfluxdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeModel {
    private String id;
    private String empName;
    private String bloodGroup;
    private String religion;
}
