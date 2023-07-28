package com.example.reactivedemo.webfluxdemo.service;

import com.example.reactivedemo.webfluxdemo.model.EmployeeModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface EmployeeService {
    public Mono<EmployeeModel> save(EmployeeModel empModel);
    public Mono<EmployeeModel> getById(String id);
    public Flux<EmployeeModel> getAll();
    public Mono<EmployeeModel> updateEmp(EmployeeModel empModel, String empId);
    public Mono<Void> deleteEmployee(String id);
    public Flux<EmployeeModel> getByBloodGroup(String bloodGroup);
    //public Flux<EmployeeModel> deleteEmployee(String id);

}
