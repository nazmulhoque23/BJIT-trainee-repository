package com.example.reactivedemo.webfluxdemo.service.impl;

import com.example.reactivedemo.webfluxdemo.entity.Employee;
import com.example.reactivedemo.webfluxdemo.mapper.EmployeeMapper;
import com.example.reactivedemo.webfluxdemo.model.EmployeeModel;
import com.example.reactivedemo.webfluxdemo.repository.EmployeeRepository;
import com.example.reactivedemo.webfluxdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;
    @Override
    public Mono<EmployeeModel> save(EmployeeModel empModel) {
        Employee employee = EmployeeMapper.mapToEmployee(empModel);
        Mono<Employee> savedEmployee = empRepository.save(employee);
        return savedEmployee.map(e->EmployeeMapper.mapToEmpModel(e));
    }

    @Override
    public Mono<EmployeeModel> getById(String id) {
        Mono<Employee> emp = empRepository.findById(id);
        return emp.map(e->EmployeeMapper.mapToEmpModel(e));
    }

    @Override
    public Flux<EmployeeModel> getAll() {
        Flux<Employee> emps = empRepository.findAll();
        return emps.map(e->EmployeeMapper.mapToEmpModel(e));
    }

    @Override
    public Mono<EmployeeModel> updateEmp(EmployeeModel empModel, String empId) {
        Mono<Employee> employee = empRepository.findById(empId);
        return employee.flatMap(emp->{
            emp.setEmpName(empModel.getEmpName());
            emp.setBloodGroup(empModel.getBloodGroup());
            emp.setReligion(empModel.getReligion());
            return empRepository.save(emp);
        }).map(e->EmployeeMapper.mapToEmpModel(e));
    }

    @Override
    public Mono<Void> deleteEmployee(String id) {
        return empRepository.deleteById(id);
    }

    @Override
    public Flux<EmployeeModel> getByBloodGroup(String bloodGroup){
        Flux<Employee> employeesByBlood = empRepository.findAllByBloodGroup(bloodGroup);
        return employeesByBlood.map(e->EmployeeMapper.mapToEmpModel(e));
    }
//    @Override
//    public Flux<EmployeeModel> deleteEmployee(String id){
//        Mono<Void> empToBeDeleted = empRepository.deleteById(id);
//        Flux<Employee> emps = empRepository.findAll();
//        return emps.map(e->EmployeeMapper.mapToEmpModel(e));
//    }
}
