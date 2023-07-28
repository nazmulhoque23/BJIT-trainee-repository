package com.example.reactivedemo.webfluxdemo.mapper;

import com.example.reactivedemo.webfluxdemo.entity.Employee;
import com.example.reactivedemo.webfluxdemo.model.EmployeeModel;

public class EmployeeMapper {
    public static EmployeeModel mapToEmpModel(Employee emp){
        return new EmployeeModel(emp.getId(),emp.getEmpName(), emp.getBloodGroup(), emp.getReligion());
    }
    public static Employee mapToEmployee(EmployeeModel empModel){
        return new Employee(empModel.getId(),empModel.getEmpName(), empModel.getBloodGroup(), empModel.getReligion());
    }
}
