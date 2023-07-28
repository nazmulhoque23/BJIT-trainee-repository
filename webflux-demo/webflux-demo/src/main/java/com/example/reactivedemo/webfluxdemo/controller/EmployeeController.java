package com.example.reactivedemo.webfluxdemo.controller;

import com.example.reactivedemo.webfluxdemo.model.EmployeeModel;
import com.example.reactivedemo.webfluxdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("web-flux")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;
    @PostMapping("/save-employee")
    public Mono<EmployeeModel> saveEmp(@RequestBody EmployeeModel empModel){
        return empService.save(empModel);
    }

    @GetMapping("/get-by-id/{id}")
    public Mono<EmployeeModel> getById(@PathVariable String id){
        return empService.getById(id);
    }

    @GetMapping("/get-all")
    public Flux<EmployeeModel> getAllEmp(){
        return empService.getAll();
    }
    @PutMapping("/update-employee/{id}")
    public Mono<EmployeeModel> updateEmp(@RequestBody EmployeeModel empModel, @PathVariable String id){
        return empService.updateEmp(empModel, id);
    }

    @DeleteMapping("/delete-employee/{id}")
    public Mono<Void> deleteEmployee(@PathVariable String id){
        return empService.deleteEmployee(id);
    }

    @GetMapping("/find-by-bloodGroup/{bloodGroup}")
    public Flux<EmployeeModel> getByBlood(@PathVariable String bloodGroup){
        return empService.getByBloodGroup(bloodGroup);
    }
//    @DeleteMapping("/delete-employee/{id}")
//    public Flux<EmployeeModel> deleteEmployee(@PathVariable String id){
//        return empService.deleteEmployee(id);
//    }

}
