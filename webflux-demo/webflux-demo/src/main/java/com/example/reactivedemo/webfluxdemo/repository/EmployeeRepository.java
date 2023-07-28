package com.example.reactivedemo.webfluxdemo.repository;

import com.example.reactivedemo.webfluxdemo.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
    Flux<Employee> findAllByBloodGroup(String bloodGroup);
}
