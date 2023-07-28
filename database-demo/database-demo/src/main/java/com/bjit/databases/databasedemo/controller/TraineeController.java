package com.bjit.databases.databasedemo.controller;

import com.bjit.databases.databasedemo.model.Trainee;
import com.bjit.databases.databasedemo.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainee")
public class TraineeController {
    @Autowired
    private TraineeService traineeService;
    @GetMapping("/all-trainee")
    public List<Trainee> allTrainee(){
        return traineeService.getAllTrainee();
    }

    @GetMapping("/fetch-by-id/{id}")
    public Trainee getById(@PathVariable Long id){
        return traineeService.getById(id);
    }
    @PostMapping("/add-trainee")
    public String addTrainee(@RequestBody Trainee trainee){
        traineeService.save(trainee);
        return "Trainee created";
    }

    @PutMapping("/update-trainee-name/{id}")
    public Trainee updateTraineeName(@RequestBody Trainee trainee, @PathVariable Long id){
        return traineeService.updateName(trainee, id);
    }

    @DeleteMapping("/delete-trainee/{id}")
    public String deleteTrainee(@PathVariable Long id){
        traineeService.deleteTrainee(id);
        return "Trainee Deleted";
    }


}
