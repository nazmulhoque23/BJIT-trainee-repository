package com.bjit.databases.databasedemo.service;

import com.bjit.databases.databasedemo.exception.NotFoundException;
import com.bjit.databases.databasedemo.model.Trainee;
import com.bjit.databases.databasedemo.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeService {
    @Autowired
    private TraineeRepository traineeRepository;

    public String save(Trainee trainee){
        traineeRepository.save(trainee);
        return " ";
    }

    public List<Trainee> getAllTrainee(){
        return traineeRepository.findAll();
    }

    public Trainee updateName(Trainee trainee, Long id){
        Optional<Trainee> trainee1 = traineeRepository.findById(id);
        if(trainee1.isPresent()){
            Trainee updatableTrainee = trainee1.get();
            updatableTrainee.setFirstName(trainee.getFirstName());
            updatableTrainee.setLastName(trainee.getLastName());

            return traineeRepository.save(updatableTrainee);
        }
        throw new NotFoundException("Data not found");

    }

    public Trainee getById(Long id){
        Optional<Trainee> trainee = traineeRepository.findById(id);
        if(trainee.isPresent()){
            Trainee requiredTrainee = trainee.get();
            return requiredTrainee;
        }
        throw new NotFoundException("Data not found");
    }

    public String deleteTrainee(Long id){
        traineeRepository.deleteById(id);
        return "";
    }

}
